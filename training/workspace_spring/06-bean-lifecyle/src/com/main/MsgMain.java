package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.MyMessage;
import com.bean.PrePostInit;

public class MsgMain {
		public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			
			
		MyMessage msg=(MyMessage)context.getBean("life");
		msg.setMessage("YOOO");
		msg.getMessage();
//		PrePostInit abc=(PrePostInit)context.getBean("");

		
		MyMessage msg1=(MyMessage)context.getBean("life");
		msg1.getMessage();
		
		
		((AbstractApplicationContext) context).registerShutdownHook();
		}
}
