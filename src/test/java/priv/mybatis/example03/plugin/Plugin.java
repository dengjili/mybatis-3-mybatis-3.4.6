/**
 * <p>Title: Plugin.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example03.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * <p>Title: Plugin.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class Plugin implements InvocationHandler {
	
	private final Object target;
	private final Interceptor interceptor;
	
	public Plugin(Object target, Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return interceptor.intercept(target, method, args);
	}

}
