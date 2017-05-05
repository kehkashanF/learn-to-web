package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
//ctr-->preinitialization-->init-->postinitialization-->businesslogic-->destroy
public class MyMessage implements InitializingBean, DisposableBean{
		private String message;
		
		public MyMessage() {
			System.out.println("IGOR! CREATE A BEAN MONSTER!!");
		}

		public MyMessage(String message) {
			super();
			this.message = message;
		}

		public void getMessage() {
			System.out.println("WEEP PUNY HUMANS: "+message);
		}

		public void setMessage(String message) {
			this.message = message;
		}
			
		public void destroy(){
			System.out.println("DIE BEAN DIE...BWAHAHHAA");
		}
		
		public void afterPropertiesSet() throws Exception {
			System.out.println("Giving birth to a bean...ouch!");
			
		}

	
}
