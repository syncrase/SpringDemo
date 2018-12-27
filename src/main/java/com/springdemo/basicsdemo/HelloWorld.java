package com.springdemo.basicsdemo;

public class HelloWorld {
	private String message = "";
	private String sT = "hi";

	public HelloWorld() {
		super();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		System.out.println("Your Message : " + message + " - " + sT);
		return this.message;
	}

	public void init() {
		this.sT = " \tinit\t";
		System.out.println("Bean is going through init.");
	}

	public void destroy() {
		System.out.println("Bean will destroy now.");
	}

}
