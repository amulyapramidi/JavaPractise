package com.amulya.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("[BEAN FACTORY]Inside CustomBeanFactoryPostProcessor");
		Laptop lp = (Laptop) arg0.getBean("laptop");
		lp.setLname("Modified In CustomBeanFactoryPostProcessor");
	}

}
