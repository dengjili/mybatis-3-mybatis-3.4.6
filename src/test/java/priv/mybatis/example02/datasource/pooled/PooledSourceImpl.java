/**
 * <p>Title: PooledSourceImpl.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月29日  
 */
package priv.mybatis.example02.datasource.pooled;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;

import priv.mybatis.example02.datasource.SourceImplWrapper;

/** 
 * <p>Title: PooledSourceImpl.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月29日  
 */
public class PooledSourceImpl extends SourceImplWrapper {

	private UnpooledDataSource dataSource;

	protected final List<ConnectionProxy> idleConnections = new ArrayList<>();
	protected final List<ConnectionProxy> activeConnections = new ArrayList<>();
	
	protected int timeoutMillis = 20000;
	protected int poolMaximumIdleSize = 5;
	protected int poolMaximumActiveSize = 10;

	public PooledSourceImpl(String driver, String url, String username, String password) {
		dataSource = new UnpooledDataSource(driver, url, username, password);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return popConnection().getProxyConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return dataSource.getConnection(username, password);
	}

	private ConnectionProxy popConnection() throws SQLException {
		ConnectionProxy connectionProxy = null;
		while (connectionProxy == null) {
			synchronized (dataSource) {
				if (!idleConnections.isEmpty()) {
					connectionProxy = idleConnections.remove(0);
				} else {
					if (activeConnections.size() < poolMaximumActiveSize) {
						connectionProxy = new ConnectionProxy(dataSource.getConnection(), this);
						activeConnections.add(connectionProxy);
					} else {
						// Cannot create new connection，尝试从超时connection，尝试回收使用
						ConnectionProxy connection = activeConnections.get(0);
						long useTimestamp = connection.getUseTimestamp();
						// 超时
						if (useTimestamp > timeoutMillis) {
							connectionProxy = connection;
							activeConnections.remove(connection);
							activeConnections.add(connectionProxy);
						} else {
							// Must wait, 等待时间到期，或者主动close释放connection
							//long wt = System.currentTimeMillis();
							try {
								dataSource.wait(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// System.out.println("Waiting as long as " + (System.currentTimeMillis() - wt) + " milliseconds for connection.");
						}
					}
				}
			}
		}
		connectionProxy.setUseTimestamp(System.currentTimeMillis());
		return connectionProxy;
	}

	protected void pushConnection(ConnectionProxy connection) throws SQLException {
		synchronized (dataSource) {
			if (idleConnections.size() < poolMaximumIdleSize) {
				idleConnections.add(connection);
				activeConnections.remove(connection);
				
				dataSource.notifyAll();
			} else {
				connection.getRealConnection().close();
			}
		}
	}
	
	public void printStatus() {
		synchronized (dataSource) {
			StringBuilder builder = new StringBuilder();
			builder.append("\n ---STATUS-----------------------------------------------------");
			builder.append("\n activeConnections              ").append(activeConnections.size());
			builder.append("\n idleConnections                ").append(idleConnections.size());
			builder.append("\n===============================================================");
			System.out.println(builder);
		}
	}

}
