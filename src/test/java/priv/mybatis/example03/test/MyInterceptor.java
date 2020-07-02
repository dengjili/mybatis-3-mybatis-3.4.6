/**
 * <p>Title: MyInterceptor.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example03.test;

import java.lang.reflect.Method;

import priv.mybatis.example03.plugin.Interceptor;

/** 
 * <p>Title: MyInterceptor.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class MyInterceptor implements Interceptor {
	@Override
	public Object intercept(Object target, Method method, Object[] args) throws Throwable {
		System.out.println("before.");
		Object invoke = method.invoke(target, args);
		System.out.println("after.");
		return invoke;
	}
}
