package com.au.codequality;

public class Child extends App{
	int age1;
	String name1;
	int id;
	String city1;
	
	Child(){
		String s = App.state;
		System.err.println(s);
	}
	
	Child object = new Child();
	int num = 0;
	String str1 = App.state;
	
}
