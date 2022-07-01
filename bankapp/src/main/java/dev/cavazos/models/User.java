package dev.cavazos.models;

// As the User, they can register a new account, login with existing credentials,
// create at least one account, deposit funds (doubles), withdraw (no overdrafting)
// and view the balance *In proper currency
public class User {
	private int id;
	private double balance;
	private String username;
	private String password;
	
	public User() {
		super();
		this.id = 0;
		this.balance = 0.00;
		this.username = "";
		this.password = "";
	}
	
	public User(String username, String password) {
		super();
		this.id = 0;
		this.balance = 0.00;
		this.username = username;
		this.password = password;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//
	public void depositFunds(double deposit) {
		// check statement (can't accept negative double)
		// can't accept any overbalance
		while(deposit > 0) {
			this.balance += deposit;
		}
	}
	
	//User can withdraw money from their balance as long as it's not overdraft
	public void withdraw(double withdraw) throws Exception {
		// check to see if they can't overdraft (withdraw > balance)
		while(withdraw < balance) {
			this.balance -= withdraw;
		}
	}
	
	//User can check their balance in a proper currency (2 point decimal)
	public double viewBalance() {
		return balance;
	}
	
	
}
