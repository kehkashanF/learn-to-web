package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wiring.Student;
import com.wiring.Student_Con;

public class Main_Wiring {

		public static void main(String[] args) {

			//BeanFactory bf=new XmlBeanFactory(new ClassPathResource("stud.xml"))
			ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
			Student s=(Student)context.getBean("stud");
			s.sayGreeting();
			
//			Student_Con sc= (Student_Con) context.getBean("stu_con");
//			System.out.println(sc);
		}
}
