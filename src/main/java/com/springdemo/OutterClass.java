package com.springdemo;

public class OutterClass {
	private InnerClass innerClass;

	public OutterClass() {
		System.out.println("Inside OutterClass constructor.");
	}

	/**
	 * Framework need, a setter method to inject the dependency.
	 * 
	 * @param innerClass
	 */
	public void setInnerClass(InnerClass innerClass) {
		System.out.println("Inside setInnerClass.");
		this.innerClass = innerClass;
	}

	public InnerClass getInnerClass() {
		return innerClass;
	}

	public void sayHello() {
		innerClass.sayHello();
	}

	public void init() {
		System.out.println("OutterClass is going through init.");
	}

	public void destroy() {
		System.out.println("OutterClass will destroy now.");
	}

}
