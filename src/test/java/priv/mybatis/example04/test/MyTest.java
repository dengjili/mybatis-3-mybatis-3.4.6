/**
 * <p>Title: MyTest.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example04.test;

import priv.mybatis.example03.demo.IPerson;
import priv.mybatis.example03.demo.PersonImpl;
import priv.mybatis.example04.plugin.Interceptor;
import priv.mybatis.example04.plugin.PluginUtils;

/** 
 * <p>Title: MyTest.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class MyTest {

	public static void main(String[] args) {
		Interceptor interceptor = new MyInterceptor3();
		IPerson person = new PersonImpl();
		IPerson personProxy = PluginUtils.wrap(person, interceptor);
		String message = personProxy.sayHello("zhangsan");
		System.out.println("return: " + message);
	}

}
