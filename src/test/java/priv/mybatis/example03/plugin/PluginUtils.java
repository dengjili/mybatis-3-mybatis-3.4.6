/**
 * <p>Title: PluginUtils.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月1日  
 */
package priv.mybatis.example03.plugin;

import java.lang.reflect.Proxy;

/** 
 * <p>Title: PluginUtils.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月1日  
 */
public class PluginUtils {
	public static <T> T wrap(T target, Interceptor interceptor) {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new Plugin(target, interceptor));
	}
}
