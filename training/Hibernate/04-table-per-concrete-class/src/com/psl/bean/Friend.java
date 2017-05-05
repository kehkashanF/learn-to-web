package com.psl.bean;

import java.sql.Date;

public class Friend extends Contact{
		private String nickName;

		public Friend() {
			super();
		}

		public Friend(String firstName, String lastName, Date dateOfBirth,
				Address address, String nickName) {
			super(firstName, lastName, dateOfBirth, address);
			this.nickName = nickName;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		
		
		
}
