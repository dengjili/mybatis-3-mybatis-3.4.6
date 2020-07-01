/**
 * <p>Title: MyPlugin.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package org.apache.ibatis.plugin.demo;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/** 
 * <p>Title: MyPlugin.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
@Intercepts({@Signature(type=Hello.class, method = "sayHello", args={})})
public class MyInterceptor implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("before.");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}

}
