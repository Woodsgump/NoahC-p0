package dev.cavazos.data;

import dev.cavazos.models.User;

/**
 * Setting up a User Data Access Object to implement the DAO for such User.
 * 
 * @author Noah Cavazos
 *
 */
public interface UserDAO extends DataAccessObject<User> {
	public User findByUsername(String username);
}
