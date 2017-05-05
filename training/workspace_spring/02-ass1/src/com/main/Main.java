package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		Employee e1=(Employee)context.getBean("emp1");
		System.out.println(e1);
		
		e1=(Employee)context.getBean("emp2");
		System.out.println(e1);
		
		e1=(Employee)context.getBean("emp3");
		System.out.println(e1);
		
	}
		
		
}
