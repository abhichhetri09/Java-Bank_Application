package JavaBankApplication;

// ************************************************************************
// Account.java	  Template created on15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account {
	 
	// Fields
	private String accountNumber; 
	private double balance;

	// Constructor
	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance; 
	}
	

	// Methods
	public void deposit(double amount) {
	   this.balance = balance + amount; 
	}
	
	public String getAccountNumber() {
		return accountNumber; 
	}
	
	public double getBalance() {
		return balance; 
	}
	
	public boolean withDraw(double amount) {
		boolean exist = false; 
		if(this.balance >= amount && amount > 0) {
			exist = true; 
			this.balance = balance - amount; 
		} else {
			exist = false; 
		}
		return exist; 
	}

}
// End