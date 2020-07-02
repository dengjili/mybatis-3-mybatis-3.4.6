/**
 * <p>Title: PluginUtils.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example04.plugin;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
 * <p>Title: PluginUtils.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class PluginUtils {
	public static <T> T wrap(T target, Interceptor interceptor) {
		Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new Plugin(target, interceptor, signatureMap));
	}
	
	// 解析注解，获取对应的类和方法
	private static Map<Class<?>, Set<Method>> getSignatureMap(Interceptor interceptor) {
		Intercepts interceptsAnnotation = interceptor.getClass().getAnnotation(Intercepts.class);
		if (interceptsAnnotation == null) {
			throw new RuntimeException(
					"No @Intercepts annotation was found in interceptor " + interceptor.getClass().getName());
		}
		
		Signature[] sigs = interceptsAnnotation.value();
		Map<Class<?>, Set<Method>> signatureMap = new HashMap<Class<?>, Set<Method>>();
		for (Signature sig : sigs) {
			Set<Method> methods = signatureMap.get(sig.type());
			if (methods == null) {
				methods = new HashSet<Method>();
				signatureMap.put(sig.type(), methods);
			}

			SignatureMethod[] signatureMethod = sig.method();
			for (int i = 0; i < signatureMethod.length; i++) {
				try {
					Method method = sig.type().getMethod(signatureMethod[i].method(), signatureMethod[i].args());
					methods.add(method);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(
							"Could not find method on " + sig.type() + " named " + sig.method() + ". Cause: " + e, e);
				}
			}
		}
		return signatureMap;
	}
}
