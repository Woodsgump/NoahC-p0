package dev.cavazos.models;

import java.util.Objects;

public class Account {
	private int id;
	private String name;
	private double balance;
	
	public Account() {
		super();
		this.id = 0;
		this.name = "";
		this.balance = 0.00;
	}
	
	public Account(int id, String name, double balance) {
		super();
		this.id = 0;
		this.name = name;
		this.balance = balance;
	}
	
}
