package com.amulya.annotation.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(0)
@Component
public class CustomBeanPostProcessor1 implements BeanPostProcessor{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("###[Before2]Inside postProcessBeforeInitialization : "+beanName);
		if(beanName.equalsIgnoreCase("Laptop"))
			((Laptop)bean).setLname("Modified in PostProcessor");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("###[After2]Inside postProcessAfterInitialization : "+beanName);
		return bean;
	}


}
