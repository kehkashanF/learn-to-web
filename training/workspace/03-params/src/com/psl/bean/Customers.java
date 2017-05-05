package com.psl.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="customers")
public class Customers {
		private List<Customer> customers;
		private AtomLink next;
		private AtomLink previous;

		
		public Customers() {
		}
		
		@XmlElementRef
		public List<Customer> getCustomers() {
			return customers;
		}
		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}
		
		@XmlElementRef
		public AtomLink getNext() {
			return next;
		}
		public void setNext(AtomLink next) {
			this.next = next;
		}

		@XmlElementRef
		public AtomLink getPrevious() {
			return previous;
		}

		public void setPrevious(AtomLink previous) {
			this.previous = previous;
		}

		
		
		
		
}
