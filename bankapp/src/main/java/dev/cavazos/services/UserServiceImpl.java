package dev.cavazos.services;

import dev.cavazos.data.UserDAO;
import dev.cavazos.data.UserPostgres;

public class UserServiceImpl {
	private UserDAO userDao = new UserPostgres();
	
}
