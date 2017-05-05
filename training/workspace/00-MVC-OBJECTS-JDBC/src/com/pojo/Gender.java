package com.pojo;

public class Gender {
	
			private int id;
			private String value;
			
			public Gender() {
				this.id = 1;
				this.value = "F";		
			}


			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			@Override
			public String toString() {
				return "Gender [id=" + id + ", value=" + value + "]";
			}
			
			
			

}
