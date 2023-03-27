package me.eglp.gv2.util.webinterface.js;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JavaScriptValue {

	public String setter() default "";

	public String getter() default "";
	
}
