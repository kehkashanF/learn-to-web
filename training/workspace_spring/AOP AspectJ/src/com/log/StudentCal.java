package com.log;

public class StudentCal {
		private Integer age;
		private String name;
		private int[] marks;
		
		
		public Integer getAge() {
			System.out.println("Umar ghya");
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getName() {
			System.out.println("Naam ghya");
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int[] getMarks() {
			return marks;
		}
		public void setMarks(int[] marks) {
			this.marks = marks;
		}
		
		public void printThrowException(){
			System.out.println("Exception aayaaaa...");
			throw new IllegalArgumentException();
		}
		
		public int add(){
			int ans=0;
//			for(int i:marks)
//					ans+=i;
			System.out.println("in add returning 10");
			return 10;
		}
		
		public int sub(){
			int ans=0;
//			for(int i:marks)
//				ans-=i;
			System.out.println("sab tv");
			return 0;
		}
}
