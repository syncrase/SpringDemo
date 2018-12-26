package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.beanslifecycle.CustomEventBean;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		((ConfigurableApplicationContext) context).start();
		((ConfigurableApplicationContext) context).stop();
		// Helloworld example
		// HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		// objA.setMessage("I'm object A");
		// objA.getMessage();
		// HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		// objB.getMessage();

		// Encapsulate beans example
		// OutterClass outterClass = (OutterClass) context.getBean("outterClass");
		// outterClass.sayHello();

		// Collection example
		// PassedDataFormat jc = (PassedDataFormat) context.getBean("passedDataFormat");

		// jc.getAddressList();
		// jc.getAddressSet();
		// jc.getAddressMap();
		// jc.getAddressProp();
		// jc.getMyString();

		// Custom event example
		// CustomEventBean cvp = (CustomEventBean) context.getBean("customEventBean");
		//
		// cvp.publish();
		// cvp.publish();

//		Student student = (Student) context.getBean("student");
//		student.getName();
//		student.getAge();
//		student.printThrowException();

		// Closing the context
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}
