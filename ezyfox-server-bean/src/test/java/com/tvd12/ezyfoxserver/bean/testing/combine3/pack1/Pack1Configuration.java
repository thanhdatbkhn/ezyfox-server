package com.tvd12.ezyfoxserver.bean.testing.combine3.pack1;

import com.tvd12.ezyfoxserver.bean.EzyBeanNameTranslator;
import com.tvd12.ezyfoxserver.bean.EzyBeanNameTranslatorAware;
import com.tvd12.ezyfoxserver.bean.annotation.EzyConfiguration;
import com.tvd12.ezyfoxserver.bean.annotation.EzySingleton;

import lombok.Setter;

@EzyConfiguration
public class Pack1Configuration implements EzyBeanNameTranslatorAware {

	@Setter
	private EzyBeanNameTranslator beanNameTranslator;
	
	@EzySingleton
	public B b = new BImpl();
	
	@EzySingleton
	public C c = new CImpl();
	
	@EzySingleton
	public D d = new DImpl();
	
	@EzySingleton
	public ClassA newClassA(ClassB classB) {
		return new ClassA();
	}
	
	@EzySingleton
	public ClassB newClassB() {
		return new ClassB();
	}
	
	
	public static class ClassA {
		
	}
	
	public static class ClassB {
		
	}
}
