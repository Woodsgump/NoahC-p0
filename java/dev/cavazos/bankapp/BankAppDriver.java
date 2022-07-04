package dev.cavazos.bankapp;

import java.util.Scanner;

import dev.cavazos.exceptions.AccountAlreadyExistsException;
import dev.cavazos.exceptions.UserNameAlreadyExistsException;
import dev.cavazos.models.Account;
import dev.cavazos.models.User;
import dev.cavazos.services.UserServiceImpl;
/**
 * A driver for the banking application where the user is the customer and they register/login to a bank for financial business.
 * 
 * @author Noah Cavazos
 *
 */
public class BankAppDriver {
	private static Scanner scanner = new Scanner(System.in);
	private static UserServiceImpl userService = new UserServiceImpl();
	
	public static void main(String[] args) throws Exception {
		// set the condition to the while loop to be true until the user is done
		boolean usingBankApp = true;
		// pretty nice interface
		System.out.println("-----------------------------------------------------------");
		System.out.println("Welcome to the Bank!");
		System.out.println("-----------------------------------------------------------");
		
		User user = null;
		Account acc = null;
		while(usingBankApp) {
			if(user == null && acc == null) {
				System.out.println("Please select one of the following options:\n" +
						"1. Login\n" +
						"2. Register an account\n" +
						"   Quit");
				System.out.println("-----------------------------------------------------------");
				
				String input = scanner.nextLine();
				
				switch(input) {
				case "1":
					user = logIn();
					break;
				case "2":
					register(); // Register an account
					break;
				default:
					usingBankApp = false;
					System.out.println("-----------------------------------------------------------");
					System.out.println("Thank you for visiting the Bank!");
					System.out.println("-----------------------------------------------------------");
				}
			}
			
			// Logged in or already logged in
			if(user != null) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Welcome " + user.getName() + ", what would you like to do?");
				System.out.println("-----------------------------------------------------------");
				System.out.println("1. View Balance\n"
						+ "2. Deposit funds\n"
						+ "3. Withdraw funds");
				System.out.println("-----------------------------------------------------------");
				String input = scanner.next();
				
				switch (input) {
				case "1":
					System.out.println("-----------------------------------------------------------");
					System.out.println("You have a current balance of: " + user.getBalance());
					System.out.println("-----------------------------------------------------------");
					break;
				case "2":
					System.out.println("-----------------------------------------------------------");
					System.out.println("How much would you like to deposit:");
					System.out.println("-----------------------------------------------------------");
					double deposit = scanner.nextDouble();
					user.depositFunds(deposit);
					break;
				case "3":
					System.out.println("-----------------------------------------------------------");
					System.out.println("How much would you like to withdraw: ");
					System.out.println("-----------------------------------------------------------");
					double withdraw = scanner.nextDouble();
					user.withdraw(withdraw);
					break;
				default:
					System.out.println("Logging out....");
					System.out.println("-----------------------------------------------------------");
					user = null;
					usingBankApp = false;
					System.out.println("-----------------------------------------------------------");
					System.out.println("Thank you for visiting the Bank!");
					System.out.println("-----------------------------------------------------------");
				}
			}
		}
			scanner.close();
		}
		
		// Properly set up the structure and proccess to which the user logs in to their bank account.
		private static User logIn() {
			boolean logging = true;
			
			while(logging) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Enter your username: ");
				System.out.println("-----------------------------------------------------------");
				String username = scanner.nextLine();
				System.out.println("-----------------------------------------------------------");
				System.out.println("Enter your password: ");
				System.out.println("-----------------------------------------------------------");
				String password = scanner.nextLine();
				
				User user = userService.logIn(username, password);
				
				if(user == null) {
					System.out.println("-----------------------------------------------------------");
					System.out.println("The user does not match one in the database.");
					System.out.println("Do you want to try again? y/n");
					System.out.println("-----------------------------------------------------------");
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
		
		// Same as the login method above but for register where the user creates an account.
		private static void register() {
			boolean registering = true;
		
			while(registering) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Enter a username: ");
				System.out.println("-----------------------------------------------------------");
				String username = scanner.nextLine();
				System.out.println("-----------------------------------------------------------");
				System.out.println("Enter a password: ");
				System.out.println("-----------------------------------------------------------");
				String password = scanner.nextLine();
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("Type \"y\" to confirm, \"n\" to try again");
				System.out.println("-----------------------------------------------------------");
				String input = scanner.nextLine().toLowerCase();
			
				switch(input) {
				case "y":
					User user = new User(username, password);
					Account acc = new Account(username, user.getBalance(), user.getID());
					try {
						userService.registerUser(user);
						userService.registerAccount(acc);
						registering = false;
						System.out.println("-----------------------------------------------------------");
						System.out.println("Success!");
						System.out.println("-----------------------------------------------------------");
					} catch (UserNameAlreadyExistsException | AccountAlreadyExistsException e) {
						System.out.println("-----------------------------------------------------------");
						System.out.println("A user with that name already exists.");
						System.out.println("-----------------------------------------------------------");
					}
					break;
				case "n":
					System.out.println("-----------------------------------------------------------");
					System.out.println("Please try again.");
					System.out.println("-----------------------------------------------------------");
					registering = false;
				}
			}
		}
	
}