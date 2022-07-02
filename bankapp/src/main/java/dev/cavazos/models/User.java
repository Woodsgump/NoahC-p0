package dev.cavazos.models;

import java.util.Objects;

import dev.cavazos.ds.ArrayList;
import dev.cavazos.ds.List;

// As the User, they can register a new account, login with existing credentials,
// create at least one account, deposit funds (doubles), withdraw (no overdrafting)
// and view the balance *In proper currency
public class User {
	private int id;
	private double balance;
	private String username;
	private String password;
	private List<Account> accounts;
	
	public User() {
		this.id = 0;
		this.balance = 0.00;
		this.username = "";
		this.password = "";
		this.accounts = new ArrayList<>();
	}
	
	public User(String username, String password) {
		this.id = 0;
		this.balance = 0.00;
		this.username = username;
		this.password = password;
		this.accounts = new ArrayList<>();
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	public void setName(String name) {
		this.username = name;
	}
	
	public String getName() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
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
	
	public List<Account> getAccounts(){
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, balance, id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accounts, other.accounts)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", balance=" + balance + ", username=" + username + ", password=" + password
				+ ", accounts=" + accounts + "]";
	}
	
}
