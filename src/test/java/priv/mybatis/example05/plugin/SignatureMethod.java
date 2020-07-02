/**
 * <p>Title: Signature.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年7月2日  
 */
package priv.mybatis.example05.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface SignatureMethod {
	String method();

	Class<?>[] args();
}
