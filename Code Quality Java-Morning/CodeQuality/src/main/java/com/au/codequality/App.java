package com.au.codequality;

public class App {
	int age;
	String name;
	String city = "city";
	String str = "";
	static String state = "A    B";
	int count = 0;

	public static void main(String[] args) throws CloneNotSupportedException {
		App object = new App();
		Object app = object.printClass(object.getClass());
		app.getClass();
		try {
			int n = object.getNum();
			System.err.println(n);
		} 
		catch (ArithmeticException e) {
			e.getMessage();
		}
		Object o = object.clone();
		System.err.println(o);
	}

	private int getNum() {
		count++;
		int a = 0;
		int b;
		switch (a) {
		case 0:
			b = 0;
			break;
		case 1:
			b = 1;
			break;
		case 5:
			b = 5;
			break;
		default:
			b = 12;
			break;
		}
		return b;
	}

	private Class<? extends App> printClass(Class<? extends App> app) {
		int[] arrayInt = new int[5];
		for (int i = 0; i < arrayInt.length; i++) {
			if (i == 2)
				break;
		}
		return app;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		int beginIndex = 1;
		char char1 = 'a';
		String init = "Bob is a Bird... Bob is a Plane... Bob is Superman!";
		String changed = init.replace("Bob is", "It's");
		changed = changed.replace("\\.\\.\\.", ";");
		return(changed.indexOf(char1, beginIndex));
	}

}
