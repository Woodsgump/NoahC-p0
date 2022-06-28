package models;

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
	
	public void depositFunds(double deposit) {
		this.balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		this.balance -= withdraw;
	}
	
	public double viewBalance() {
		return balance;
	}
	
	
}
