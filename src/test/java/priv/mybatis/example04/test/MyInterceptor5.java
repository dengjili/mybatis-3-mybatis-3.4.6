/**
 * <p>Title: MyInterceptor.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example04.test;

import java.lang.reflect.Method;

import priv.mybatis.example03.demo.IPerson;
import priv.mybatis.example04.plugin.Interceptor;
import priv.mybatis.example04.plugin.Intercepts;
import priv.mybatis.example04.plugin.Signature;
import priv.mybatis.example04.plugin.SignatureMethod;

/** 
 * <p>Title: MyInterceptor.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
@Intercepts({
		@Signature(type = IPerson.class, method = { 
				@SignatureMethod(method = "sayHello", args = { String.class }) }) })
public class MyInterceptor5 implements Interceptor {
	@Override
	public Object intercept(Object target, Method method, Object[] args) throws Throwable {
		System.out.println("5555.");
		Object invoke = method.invoke(target, args);
		return invoke;
	}
}
