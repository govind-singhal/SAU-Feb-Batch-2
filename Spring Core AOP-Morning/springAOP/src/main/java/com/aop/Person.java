package com.aop;

public class Person {
	
	private Car car;
	private Mobile mobile;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
	
	

}
