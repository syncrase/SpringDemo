package com.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.beanslifecycle.CustomEventBean;
import com.springdemo.dao.Student;
import com.springdemo.dao.StudentJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		((ConfigurableApplicationContext) context).start();
		((ConfigurableApplicationContext) context).stop();

		helloWorldExample(context);
		encapsulatedBeanExample(context);
		collectionsInConfigurationFileExample(context);
		customEventExample(context);
		aopFeatureExample(context);
		springJDBCExample(context);

		// Closing the context
		((AbstractApplicationContext) context).registerShutdownHook();
	}

	/**
	 * @param context
	 */
	private static void helloWorldExample(ApplicationContext context) {
		/*
		 * Helloworld example
		 */
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}

	/**
	 * @param context
	 */
	private static void encapsulatedBeanExample(ApplicationContext context) {
		/*
		 * Encapsulate beans example
		 */
		OutterClass outterClass = (OutterClass) context.getBean("outterClass");
		outterClass.sayHello();
	}

	/**
	 * @param context
	 */
	private static void collectionsInConfigurationFileExample(ApplicationContext context) {
		/*
		 * Collection example
		 */
		PassedDataFormat jc = (PassedDataFormat) context.getBean("passedDataFormat");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
		jc.getMyString();
	}

	/**
	 * @param context
	 */
	private static void customEventExample(ApplicationContext context) {
		/*
		 * Custom event example
		 */
		CustomEventBean cvp = (CustomEventBean) context.getBean("customEventBean");
		cvp.publish();
		cvp.publish();
	}

	/**
	 * @param context
	 */
	private static void aopFeatureExample(ApplicationContext context) {
		/*
		 * Example using the spring AOP feature. cf Beans configuration and
		 * com.springdemo.Logging implementation
		 */
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		try {
			student.printThrowException();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}

	/**
	 * @param context
	 */
	private static void springJDBCExample(ApplicationContext context) {
		/*
		 * Spring JDBC Example
		 */
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
//		System.out.println(TimeZone.getTimeZone("TimeZone").toString());
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);

		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();

		System.out.println("------Listing All --------");
		StringBuilder sb = new StringBuilder();
		for (Student record : students) {
			sb.append("ID : " + record.getId());
			sb.append(", Name : " + record.getName());
			sb.append(", Age : " + record.getAge());
			sb.append("\n");
		}
		System.out.println(sb.toString());

		int id = students.get(students.size() - 1).getId();
		System.out.println(String.format("----Updating Record with ID = %d -----", id));
		studentJDBCTemplate.update(id, 20);

		System.out.println(String.format("----Listing Record with ID = %d -----", id));
		Student student = studentJDBCTemplate.getStudent(id);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());

		studentJDBCTemplate.deleteAll();
	}

}
