/**
 * <p>Title: MyTest.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example04.test;

import priv.mybatis.example03.demo.IPerson;
import priv.mybatis.example03.demo.PersonImpl;
import priv.mybatis.example04.plugin.InterceptorChain;

/** 
 * <p>Title: MyTest.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class MyTest2 {

	public static void main(String[] args) {
		InterceptorChain chain = new InterceptorChain();
		chain.addInterceptor(new MyInterceptor3());
		chain.addInterceptor(new MyInterceptor4());
		chain.addInterceptor(new MyInterceptor5());
		IPerson person = new PersonImpl();
		IPerson personProxy = (IPerson) chain.wrapAll(person);
		String message = personProxy.sayHello("zhangsan");
		System.out.println("return: " + message);
	}

}
