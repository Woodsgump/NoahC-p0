package dev.cavazos.services;

import dev.cavazos.data.UserDAO;
import dev.cavazos.data.UserPostgres;

public class UserServiceImpl { // Use this for register instead of UserService
	private UserDAO userDao = new UserPostgres();
	
}
