package dev.cavazos.services;

import dev.cavazos.data.AccountDAO;
import dev.cavazos.data.AccountPostgres;
import dev.cavazos.data.UserDAO;
import dev.cavazos.data.UserPostgres;
import dev.cavazos.ds.List;
import dev.cavazos.exceptions.UserNameAlreadyExistsException;
import dev.cavazos.models.Account;
import dev.cavazos.models.User;

public class UserServiceImpl implements UserService { // Use this for register instead of UserService
	private UserDAO userDao = new UserPostgres();
	private AccountDAO accDao = new AccountPostgres();

	@Override
	public User registerUser(User user) throws UserNameAlreadyExistsException {
		user = userDao.create(user);
		if(user == null) {
			throw new UserNameAlreadyExistsException();
		}
		return user;
	}

	@Override
	public User logIn(String username, String password) {
		User user = userDao.findByUsername(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public List<Account> viewAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
