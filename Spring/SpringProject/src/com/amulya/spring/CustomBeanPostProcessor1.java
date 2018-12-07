package com.amulya.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CustomBeanPostProcessor1 implements BeanPostProcessor,Ordered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("[Before2]Inside postProcessBeforeInitialization : "+beanName);
		if(beanName.equalsIgnoreCase("Laptop"))
			((Laptop)bean).setLname("Modified in PostProcessor");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("[After2]Inside postProcessAfterInitialization : "+beanName);
		return bean;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
