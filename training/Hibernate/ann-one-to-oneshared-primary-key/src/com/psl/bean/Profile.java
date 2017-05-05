package com.psl.bean;

import javax.persistence.*;

@Entity
@Table
public class Profile {
	
	@Id
	@Column
		private int profileId;
		private int schoolYear, collegeYear;
		
		@OneToOne
		@MapsId
		private Contact contact;
		public Profile() {
			
		}
		public Profile(int schoolYear, int collegeYear) {
			super();
			this.schoolYear = schoolYear;
			this.collegeYear = collegeYear;
		}
		public int getProfileId() {
			return profileId;
		}
		public void setProfileId(int profileId) {
			this.profileId = profileId;
		}
		public int getSchoolYear() {
			return schoolYear;
		}
		public void setSchoolYear(int schoolYear) {
			this.schoolYear = schoolYear;
		}
		public int getCollegeYear() {
			return collegeYear;
		}
		public void setCollegeYear(int collegeYear) {
			this.collegeYear = collegeYear;
		}
		public void setContact(Contact contact) {
			this.contact = contact;
		}
		public Contact getContact() {
			return contact;
		}
		
		
		
		
}