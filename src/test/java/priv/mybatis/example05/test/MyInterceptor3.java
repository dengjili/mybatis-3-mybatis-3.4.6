/**
 * <p>Title: MyInterceptor.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example05.test;

import java.lang.reflect.Method;

import priv.mybatis.example03.demo.IPerson;
import priv.mybatis.example05.plugin.Interceptor;
import priv.mybatis.example05.plugin.Intercepts;
import priv.mybatis.example05.plugin.Invocation;
import priv.mybatis.example05.plugin.Signature;
import priv.mybatis.example05.plugin.SignatureMethod;

/** 
 * <p>Title: MyInterceptor.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
@Intercepts({
		@Signature(type = IPerson.class, method = { 
				@SignatureMethod(method = "sayHello", args = { String.class }) }) })
public class MyInterceptor3 implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("3333.");
		Object invoke = invocation.proceed();
		return invoke;
	}
}
