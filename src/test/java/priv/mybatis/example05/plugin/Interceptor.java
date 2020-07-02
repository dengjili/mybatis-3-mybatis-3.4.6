/**
 * <p>Title: Interceptor.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example05.plugin;

/** 
 * <p>Title: Interceptor.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public interface Interceptor {
	 Object intercept(Invocation invocation) throws Throwable;
}
