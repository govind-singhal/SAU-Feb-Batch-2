package com.people.test;

import com.people.management.PeopleImpl;
import com.people.management.PeopleImplService;

public class TestService {
	public static void main(String[] args) {
		PeopleImplService wsdl = new PeopleImplService();
		PeopleImpl service = wsdl.getPeopleImpl();
		service.setName("Govind");
		System.out.println(service.getName()+"\t "+service.getAge());
	}

}
