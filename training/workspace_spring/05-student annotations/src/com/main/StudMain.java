package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.MyStudent;

public class StudMain {
		public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			
			MyStudent myStudent=(MyStudent)context.getBean("abc");
			System.out.println(myStudent);
		}
}
