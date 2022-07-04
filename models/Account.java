package dev.cavazos.models;

import java.util.Objects;

/**
 * Making an Account model to reference and share a many to on relationship with Customer(User).
 * 
 * @author Noah Cavazos
 *
 */
public class Account {
	private int id;
	private String name;
	private double balance;
	private int user;
	
	/**
	 * Constructor
	 */
	public Account() {
		this.id = 0;
		this.name = "";
		this.balance = 0.00;
		this.user = 0;
	}
	
	/**
	 * Another Constructor for instantiating a new instance of Account
	 * 
	 * @param name the name of the user who created the account
	 * @param balance the balance that the user has
	 * @param user the id of the user referencing to the customer table
	 */
	public Account(String name, double balance, int user) {
		this.id = 0;
		this.name = name;
		this.balance = balance;
		this.user = user;
	}
	
	/**
	 * Retrieving the ID of said Account instance
	 * 
	 * @return id the primary ID of said account
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of an Account instance
	 * 
	 * @param id the primary ID of said account
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the username of said Account instance
	 * 
	 * @return name the username who created the account
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the username of who created the account.
	 * 
	 * @param name the username of customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the balance of the user who made the account.
	 * 
	 * @return balance the amount of money in the account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance by the user who modifies it via deposite/withdraw on their account.
	 * 
	 * @param user their balance
	 */
	public void setBalance(User user) {
		this.balance = user.getBalance();
	}
	
	/**
	 * Retrieves the instance of customer
	 * 
	 * @return user an instance of User
	 */
	public int getCustomer() {
		return user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, name, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", user=" + user + "]";
	}
	
}
