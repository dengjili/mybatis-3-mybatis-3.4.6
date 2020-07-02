/**
 * <p>Title: Plugin.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example04.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/** 
 * <p>Title: Plugin.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class Plugin implements InvocationHandler {

	private final Object target;
	private final Interceptor interceptor;
	private final Map<Class<?>, Set<Method>> signatureMap;

	public Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
		this.target = target;
		this.interceptor = interceptor;
		this.signatureMap = signatureMap;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Set<Method> methods = signatureMap.get(method.getDeclaringClass());
		if (methods != null && methods.contains(method)) {
			return interceptor.intercept(target, method, args);
		}
		return method.invoke(target, args);
	}

}
