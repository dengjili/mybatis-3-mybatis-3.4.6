/**
 * <p>Title: PersonImpl.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example03.demo;

/** 
 * <p>Title: PersonImpl.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class PersonImpl implements IPerson {

	@Override
	public String sayHello(String name) {
		String msg = "hello, " + name;
		System.out.println(msg);
		return msg;
	}

	@Override
	public void test() {
		System.out.println("test");
	}

}
