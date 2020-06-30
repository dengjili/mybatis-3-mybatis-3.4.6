/**
 * <p>Title: ConnectionProxy.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月29日  
 */
package priv.mybatis.example02.datasource.pooled;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/** 
 * <p>Title: ConnectionProxy.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月29日  
 */
public class ConnectionProxy implements InvocationHandler {
	
	private final PooledSourceImpl dataSource;
	private final Connection realConnection;
	private final Connection proxyConnection;
	
	private long useTimestamp; 
	
	public ConnectionProxy(Connection connection, PooledSourceImpl dataSource) {
		this.dataSource = dataSource;
		this.realConnection = connection;
		this.proxyConnection = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class<?>[] { Connection.class }, this);
	}

	public Connection getRealConnection() {
		return realConnection;
	}

	public Connection getProxyConnection() {
		return proxyConnection;
	}
	
	public long getUseTimestamp() {
		return System.currentTimeMillis() - useTimestamp;
	}

	public void setUseTimestamp(long useTimestamp) {
		this.useTimestamp = useTimestamp;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("close".equals(method.getName())) {
			dataSource.pushConnection(this);
			return null;
		} else {
			return method.invoke(realConnection, args);
		}
	}

}
