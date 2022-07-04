package dev.cavazos.exceptions;

/**
 * Checking to see if an account with the same name already exists if a user
 * tries to register/login.
 * 
 * @author Noah Cavazos
 *
 */
//because this extends Exception (rather than RunTimeException),
//it is a checked exception, meaning that we have to handle it
//using a try-catch or throws.
public class AccountAlreadyExistsException extends Exception {

}