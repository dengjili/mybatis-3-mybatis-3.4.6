/**
 * <p>Title: Hello.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package org.apache.ibatis.plugin.demo;

/** 
 * <p>Title: Hello.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class HelloImpl implements Hello{
	public void sayHello() {
		System.out.println("hello");
	}

	@Override
	public void sayHello2() {
		System.out.println("hello2");
	}
}
