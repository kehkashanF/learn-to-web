package com.psl.bean;

public class Account {
		private int accountId;
		private double balance;
		private User user;
		
		public Account() {
			// TODO Auto-generated constructor stub
		}

		
		public Account(double balance) {
			super();
			
			this.balance = balance;
		}


		public int getAccountId() {
			return accountId;
		}

		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		
}
