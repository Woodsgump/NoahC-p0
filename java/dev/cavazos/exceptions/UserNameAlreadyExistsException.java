package dev.cavazos.exceptions;

/**
 * Checking to see if a Username of said new user is to be organized so
 * no user with the same name can have the same username.
 * 
 * @author Noah Cavazos
 *
 */
// because this extends Exception (rather than RunTimeException),
// it is a checked exception, meaning that we have to handle it
// using a try-catch or throws.
public class UserNameAlreadyExistsException extends Exception {

}