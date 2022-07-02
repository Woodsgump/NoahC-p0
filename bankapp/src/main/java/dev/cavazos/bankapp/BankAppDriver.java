package dev.cavazos.bankapp;

import java.util.Scanner;

import dev.cavazos.exceptions.UserNameAlreadyExistsException;
import dev.cavazos.models.User;
import dev.cavazos.services.UserServiceImpl;

public class BankAppDriver {
	private static Scanner scanner = new Scanner(System.in);
	private static UserServiceImpl userService = new UserServiceImpl();
	
	public static void main(String[] args) throws Exception {
		boolean usingBankApp = true;
		System.out.println("Welcome to the Bank!");
		
		User user = null;
		while(usingBankApp) {
			if(user == null) {
				System.out.println("Please select one of the following options:\n" +
						"1. Login\n" +
						"2. Register an account\n" +
						"   Quit");
				
				String input = scanner.nextLine();
				
				switch(input) {
				case "1":
					user = logIn(); // TODO: Find the username that's already in the database
					break;
				case "2":
					register(); // Register an account
					break;
				default:
					usingBankApp = false;
					System.out.println("Thank you for visitng the Bank!");
				}
			}
			
			// Logged in or already logged in
			if(user != null) {
				System.out.println("Welcome, what would you like to do?"); // add the user's name in it somehow...
				System.out.println("1. View Balance\n"
						+ "2. Deposit funds\n"
						+ "3. Withdraw funds");
				String input = scanner.next();
				
				switch (input) {
				case "1":
					user.viewBalance();
					break;
				case "2":
					System.out.println("How much would you like to deposit:");
					double deposit = scanner.nextDouble();
					user.depositFunds(deposit);
					break;
				case "3":
					System.out.println("How much would you like to withdraw: ");
					double withdraw = scanner.nextDouble();
					user.withdraw(withdraw);
					break;
				default:
					System.out.println("Logging out....");
					user = null;
				}
			}
		}
			scanner.close();
		}
		
		private static User logIn() {
			boolean logging = true;
			
			while(logging) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();
				
				User user = userService.logIn(username, password);
				
				if(user == null) {
					System.out.println("The user does not match one in the database.");
					System.out.println("Do you want to try again? y/n");
					String input = scanner.nextLine().toLowerCase();
					// if "yes"
					if(!("y".equals(input))) {
						logging = false;
					}
				} else {
					return user;
				}
			}
			return null;
		}
		

		private static void register() {
			boolean registering = true;
		
			while(registering) {
				System.out.println("Enter a username: ");
				String username = scanner.nextLine();
				System.out.println("Enter a password: ");
				String password = scanner.nextLine();
			
				System.out.println("Type \"y\" to confirm, \"n\" to try again");
				String input = scanner.nextLine().toLowerCase();
			
				switch(input) {
				case "y":
					User user = new User(username, password);
					try {
						userService.registerUser(user);
						registering = false;
						System.out.println("Success!");
					} catch (UserNameAlreadyExistsException e) {
						System.out.println("A user with that name already exists.");
					}
					break;
				case "n":
					System.out.println("Please try again.");
					registering = false;
				}
			}
		}
	
}