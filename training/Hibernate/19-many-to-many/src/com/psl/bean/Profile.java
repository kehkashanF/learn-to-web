package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Profile {
		private int profileId;
		private int schoolYear, collegeYear;
		private Contact contact;
		//MANY-TO-MANY --> a single profile can earn many egres
		private Set<Degree> degrees = new HashSet<Degree>();
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
		public void setDegrees(Set<Degree> degrees) {
			this.degrees = degrees;
		}
		public Set<Degree> getDegrees() {
			return degrees;
		}
		
		public void addDegree(Degree degree){
			getDegrees().add(degree);
			degree.getProfiles().add(this);	
		}
		
}
