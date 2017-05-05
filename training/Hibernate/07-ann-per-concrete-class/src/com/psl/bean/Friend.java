package com.psl.bean;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FRIEND_TBL")
@AttributeOverrides({
    @AttributeOverride(name="firstName", column=@Column(name = "first_name")),
    @AttributeOverride(name="lastName", column=@Column(name = "last_name")),
    @AttributeOverride(name="dateOfBirth", column=@Column(name = "dob")),
    @AttributeOverride(name="address", column=@Column(name = "address"))
})
public class Friend extends Contact{
	@Column(name = "nick_Name")
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
