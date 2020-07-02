/**
 * <p>Title: InterceptorChain.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月2日  
 */
package priv.mybatis.example05.plugin;

import java.util.ArrayList;
import java.util.List;


/** 
 * <p>Title: InterceptorChain.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年7月2日  
 */
public class InterceptorChain {

	private final List<Interceptor> interceptors = new ArrayList<>();

	public Object wrapAll(Object target) {
		for (Interceptor interceptor : interceptors) {
			target = PluginUtils.wrap(target, interceptor);
		}
		return target;
	}

	public void addInterceptor(Interceptor interceptor) {
		interceptors.add(interceptor);
	}
}