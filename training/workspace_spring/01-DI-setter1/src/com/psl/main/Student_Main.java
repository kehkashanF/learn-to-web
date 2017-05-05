package com.psl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.pojo.Student;
import com.psl.pojo.Student_Constructor;
import com.psl.setter_ref.Student_ref;

public class Student_Main {
		public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			//using setters
			Student stud = (Student) context.getBean("s");
			
			System.out.println(stud);
			
			stud=(Student) context.getBean("s1");
			System.out.println(stud);
			
			//ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			//Using constructor injection
			Student_Constructor stud_c=(Student_Constructor)context.getBean("sc");
			System.out.println(stud_c);
			
			//Composition
			
//			ApplicationContext con=new ClassPathXmlApplicationContext("beans.xml");
			Student_ref sref=(Student_ref)context.getBean("sr");
			System.out.println(sref);
			
			
			//ctr with composition
			Student_ref sctrref=(Student_ref)context.getBean("src");
			System.out.println(sctrref);
			
			//using p:
			stud = (Student) context.getBean("s_prop");
			System.out.println(stud);
		}
}
