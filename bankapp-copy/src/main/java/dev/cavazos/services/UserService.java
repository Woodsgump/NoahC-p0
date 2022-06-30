package dev.cavazos.services;

import dev.cavazos.ds.List;
import dev.cavazos.exceptions.UserNameAlreadyExistsException;
//import dev.cavazos.models.Bank;
import dev.cavazos.models.User;

public interface UserService {
	/**
	 * Creates a new user in the application and returns the newly 
	 * created user. If a user with that username already exists, it 
	 * will throw an exception.
	 * 
	 * @param user the new user to be created
	 * @return the created user
	 * @throws UsernameAlreadyExistsException
	 */
	public User registerUser(User user) throws UserNameAlreadyExistsException;
	
	/**
	 * Retrieves a user with the specified username in the application, 
	 * returning that user only if the specified password matches the password 
	 * of the retrieved user.
	 * 
	 * @param username the username of the desired user
	 * @param password the password of the desired user
	 * @return the user matching the username if the password matches or null if there is 
	 * no user with that username or the password does not match
	 */
	public User logIn(String username, String password);
}