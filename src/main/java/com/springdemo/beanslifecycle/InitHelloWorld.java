package com.springdemo.beanslifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("Start initialization : " + beanName);
		return bean; // you can return any other object as well
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("End initialization : " + beanName);
		return bean; // you can return any other object as well
	}

}
