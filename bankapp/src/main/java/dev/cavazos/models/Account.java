package dev.cavazos.models;

import java.util.Objects;

public class Account {
	private int id;
	private String name;
	private double balance;
	private User user;
	
	public Account() {
		this.id = 0;
		this.name = "";
		this.balance = 0.00;
		this.user = new User();
	}
	
	public Account(int id, String name, double balance, User user) {
		this.id = 0;
		this.name = name;
		this.balance = balance;
		this.user = new User();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public User getCustomer() {
		return user;
	}

	public void setStatus(User user) {
		this.user = user;
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
