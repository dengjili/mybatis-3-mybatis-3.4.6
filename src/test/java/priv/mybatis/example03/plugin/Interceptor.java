/**
 * <p>Title: Interceptor.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example03.plugin;

import java.lang.reflect.Method;

/** 
 * <p>Title: Interceptor.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public interface Interceptor {
	 Object intercept(Object target, Method method, Object[] args) throws Throwable;
}
