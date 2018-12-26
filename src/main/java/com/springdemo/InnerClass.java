package com.springdemo;

public class InnerClass {
	
	public InnerClass() {
		System.out.println("Inside InnerClass constructor.");
	}

	public void sayHello() {
		System.out.println("Hello");
	}

	public void init() {
		System.out.println("InnerClass is going through init.");
	}

	public void destroy() {
		System.out.println("InnerClass will destroy now.");
	}

}
