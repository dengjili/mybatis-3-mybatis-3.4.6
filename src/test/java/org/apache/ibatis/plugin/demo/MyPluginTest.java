/**
 * <p>Title: MyPluginTest.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package org.apache.ibatis.plugin.demo;

/** 
 * <p>Title: MyPluginTest.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class MyPluginTest {
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		MyInterceptor myInterceptor = new MyInterceptor();
		Hello helloProxy = (Hello) myInterceptor.plugin(hello);
		helloProxy.sayHello();
	}
}
