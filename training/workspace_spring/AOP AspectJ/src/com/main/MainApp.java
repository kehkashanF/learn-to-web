package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.log.StudentCal;

public class MainApp {
		public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			StudentCal stud=(StudentCal)context.getBean("student");
			System.out.println(stud.add());
			System.out.println(stud.sub());
			
			//Duplicated Code
			//Tangled Code
			
		}
}
