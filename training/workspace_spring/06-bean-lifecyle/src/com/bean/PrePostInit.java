package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PrePostInit implements BeanPostProcessor{
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("SOMETHING IS STILL WRONG! (AI): "+beanName);
		return bean; //you can return any other object as well
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("SOMETHING IS WRONG! (BI): "+beanName);
		return bean; //you can return any other object as well
	}
	
}
