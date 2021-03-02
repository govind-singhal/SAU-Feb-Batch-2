package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/config.xml");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person.getCar().getCarName());
		
		person.printThrowException(); 
        
    }
}
