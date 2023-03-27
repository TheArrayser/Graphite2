package me.eglp.gv2.util.webinterface.js.settings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JavaScriptListSetting {

	public Class<?> value();

	public String valueFriendlyName();
	
}
