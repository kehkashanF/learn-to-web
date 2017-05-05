
public class BankAccount {
			private int accNo;
			private String custName;
			private String accType;
			private float balance;
			
			public BankAccount(int accNo, String custName, String accType, float balance) 
			{
				if(balance<0)
					try {
						throw new NegativeAmount("Amount cannot be nagative");
					} catch (NegativeAmount e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if(accType.equalsIgnoreCase("Savings"))
				{
					if(balance<1000)
						try {
							throw new InsufficientFunds("Savings cannot have less than Rs. 1000");
						} catch (InsufficientFunds e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else
					{
						this.accNo=accNo;
						this.custName=custName;
						this.accType=accType;
						this.balance=balance;
						
					}
				}
				else if(accType.equalsIgnoreCase("Current"))
				{
					if(balance<5000)
						try {
							throw new InsufficientFunds("Current Account cannot have less than Rs. 5000");
						} catch (InsufficientFunds e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					else
					{
						this.accNo=accNo;
						this.custName=custName;
						this.accType=accType;
						this.balance=balance;
						
					}
				}
				else
				{
					System.out.println("Not valid account");
				}
			}
			
			public void deposit(float amt){
				if(amt<0){
					try {
						throw new NegativeAmount("Amount cannot be nagative");
					} catch (NegativeAmount e) {
						
						e.printStackTrace();
					}
				}
				else
					balance=balance+amt;
				System.out.println("Current balance is: "+balance);
				
			}
			
			public void withdraw (float amt) throws NegativeAmount, InsufficientFunds
			{
				if(amt<0)
					throw new NegativeAmount("Amount cannot be nagative");
				
				if(accType.equalsIgnoreCase("Savings"))
				{
					if(balance-amt<1000)
						throw new InsufficientFunds("Savings cannot have less than Rs. 1000");
					else
						balance=balance-amt;
				}
				else if(accType.equalsIgnoreCase("Current"))
				{
					if(balance-amt<5000)
						throw new InsufficientFunds("Current Account cannot have less than Rs. 5000");
					else
						balance=balance-amt;
				}
				else
					System.out.println("Account type invalid");
				
			}
			
			public float getBalance() throws InsufficientFunds
			{
				
				if(accType.equalsIgnoreCase("Savings"))
				{
					if(balance<1000)
						throw new InsufficientFunds("Savings cannot have less than Rs. 1000");
					else
						return this.balance;
				}
				else if(accType.equalsIgnoreCase("Current"))
				{
					if(balance<5000)
						throw new InsufficientFunds("Current Account cannot have less than Rs. 5000");
					else
						return this.balance;
				}
				else
					return this.balance;
				
			}
			
			
			public void display()
			{
				
				System.out.println("Account Number: "+accNo);
				System.out.println("Name: "+custName);
				System.out.println("Account type: "+accType);
				System.out.println("Balance: "+balance);
				
			}
			
			public static void main(String[] args) {
				BankAccount ba;
					
				ba = new BankAccount(123, "ABC", "Savings", 333.00f);
				
				ba.display();
				ba.deposit(1000);
				ba.display();
				try {
					float bal=ba.getBalance();
					System.out.println("Balance is: "+bal);
				} catch (InsufficientFunds e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ba.withdraw(2000);
					ba.display();
				} catch (NegativeAmount e) {
					
					e.printStackTrace();
				} catch (InsufficientFunds e) {
					
					e.printStackTrace();
				}
			}
			
			
			
			
}
