package com.tut;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		System.out.println("Project Started");
		menu();

	}

	public static void menu() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("1. Create Employee\n2.Update Employee by ID\n3.Delete Employee\n4.Get all Employee\n5.Get Employee by Id\n6.Exit\n\nEnter Your Choice");
		Scanner input = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		do {
			
			switch (choice) {
			case 1:
				Employee emp = CreateEmployee(input);
				session.save(emp);
				System.out.println("Succesfully Created ");
				break;
			case 2:
				System.out.println("Enter Employee ID: ");
				int id = Integer.parseInt(input.nextLine());

				Employee emp1 = (Employee) session.get(Employee.class, id);
				Employee employee = UpdateEmpById(emp1,input);
				session.save(employee);
				System.out.println("Succesfully Updated ");
				break;
			case 3:
				System.out.println("Enter Employee ID: ");
				int id1 = Integer.parseInt(input.nextLine());
				Employee emp2 = (Employee) session.get(Employee.class, id1);
				System.out.println("Warning: This cannot be recovered <y/n>");
				String flag = input.nextLine();
				if (flag.equals("y")) {
					session.delete(emp2);
					System.out.println("Succesfully Deleted ");
					break;
				} else {
					break;
				}
			case 4:
				
				Criteria criteria = session.createCriteria(Employee.class);
				List<Employee> list = criteria.list();
				System.out.println("Id Fname Lname Age Salary DOB Designation");
				for(Employee test: list) {
				    System.out.println(test.getId() + " " + test.getFname() + " " + test.getLname()+ " " + test.getAge()+ " " + test.getSalary()+ " " + test.getDob()+ " " + test.getDesignation());
				}
				System.out.println("\n\n");
				break;
			case 5:
				System.out.println("Enter Employee ID: ");
				int id3 = Integer.parseInt(input.nextLine());
				Employee emp3 = (Employee) session.get(Employee.class, id3);
				System.out.println(emp3.toString());
				break;
			
				
			}
			choice = getChoice(input);
			
			
		} while (choice != 6);

		tx.commit();
		session.close();
		input.close();

	}
	private static int getChoice(Scanner input) {
		System.out.println("1. Create Employee\n2.Update Employee by ID\n3.Delete Employee\n4.Get all Employee\n5.Get Employee by Id\n6.Exit\n\nEnter Your Choice");
		//Scanner sc = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		return choice;
	}

	private static Employee UpdateEmpById(Employee emp1, Scanner sc) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Employee First name\n ");
		String fname = sc.nextLine();

		System.out.print("\nEnter Employee Last name\n ");
		String lname = sc.nextLine();

		System.out.print("\nEnter Employee age\n ");
		String age = sc.nextLine();

		System.out.print("\nEnter Employee salary\n ");
		int salary = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Employee DOB\n");
		String dob = sc.nextLine();
		System.out.print("\nEnter Employee Designation\n ");
		String designation = sc.nextLine();

		emp1.setFname(fname);
		emp1.setLname(lname);
		emp1.setAge(age);
		emp1.setSalary(salary);
		emp1.setDob(dob);
		emp1.setDesignation(designation);
		//sc.close();
		return emp1;

	}

	private static Employee CreateEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);

		Employee emp = new Employee();

		System.out.print("\nEnter Employee Id\n ");
		int id = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Employee First name\n ");
		String fname = sc.nextLine();

		System.out.print("\nEnter Employee Last name\n ");
		String lname = sc.nextLine();

		System.out.print("\nEnter Employee age\n ");
		String age = sc.nextLine();

		System.out.print("\nEnter Employee salary\n ");
		int salary = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Employee DOB\n");
		String dob = sc.nextLine();
		System.out.print("\nEnter Employee Designation\n ");
		String designation = sc.nextLine();

		emp.setId(id);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setAge(age);
		emp.setSalary(salary);
		emp.setDob(dob);
		emp.setDesignation(designation);
		//sc.close();
		return emp;

	}
}
