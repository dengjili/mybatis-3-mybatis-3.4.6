/**
 * <p>Title: MyPluginTest.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package org.apache.ibatis.plugin.demo;

import org.apache.ibatis.plugin.InterceptorChain;

/** 
 * <p>Title: MyPluginTest.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class MyInterceptorTest {
	public static void main(String[] args) {
		InterceptorChain chain = new InterceptorChain();
		chain.addInterceptor(new MyInterceptor());
		chain.addInterceptor(new MyInterceptor2());
		chain.addInterceptor(new MyInterceptor3());
		Hello hello = new HelloImpl();
		Hello helloProxy = (Hello) chain.pluginAll(hello);
		helloProxy.sayHello();
	}
}
