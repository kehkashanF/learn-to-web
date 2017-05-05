package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;
import com.dao.UserDAO;

public class UserDAOImplMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao=(UserDAO)context.getBean("userdao_dec");
		User user=new User();
		user.setEmail("abc07@gmail.com");
		user.setAddress("Nagpur");
		user.setFirstName("Faiz");
		user.setLastName("Fazal");
		user.setGender(2);
		int rec=dao.addUser(user);
		if(rec>0){
			System.out.println("data gayaaaaa");
		}
		else
			System.out.println("data nai gayaaaa");
		
	}
}
