package dev.cavazos.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import dev.cavazos.data.AccountDAO;
import dev.cavazos.data.UserDAO;
import dev.cavazos.exceptions.UserNameAlreadyExistsException;
import dev.cavazos.models.User;

/**
 * Creating a UserService Test to show the process of JUnit testing.
 * 
 * @author Noah Cavazos
 *
 */
public class UserServiceTest {
	// object to test
	@InjectMocks
	private UserService userServ = new UserServiceImpl();
	
	// UserService dependencies
	@Mock
	private UserDAO userDao;
	@Mock
	private AccountDAO accDao;
	
	@BeforeAll
	public static void setUp() {
		
	}
	
	
	// @BeforeEach, @AfterEach, @AfterAll
	
	@Test
	public void registerSuccessfully() throws UserNameAlreadyExistsException {
		User mockUser = new User();
		Mockito.when(userDao.create(mockUser)).thenReturn(mockUser);
		
		// call
		User returnedUser = userServ.registerUser(mockUser);
		
		// assertion
		assertNotNull(returnedUser);
	}
	
	@Test
	public void registerUsernameAlreadyExists() {
		User mockUser = new User();
		Mockito.when(userDao.create(mockUser)).thenReturn(null);
		
		assertThrows(UserNameAlreadyExistsException.class, () -> {
			userServ.registerUser(mockUser);
		});
	}
	
	@Test
	public void logInSuccessfully() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = "test";

		User mockUser = new User(username, password);
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertEquals(username, returnedUser.getName());
	}

	@Test
	public void logInUsernameDoesntExist() {
		// setup (inputs, mocks, etc.)
		String username = "wrong";
		String password = "test";

		Mockito.when(userDao.findByUsername(username)).thenReturn(null);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

	@Test
	public void logInWrongPassword() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = "wrong";

		User mockUser = new User(username, "test");
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

	@Test
	public void logInNullPassword() {
		// setup (inputs, mocks, etc.)
		String username = "test";
		String password = null;

		User mockUser = new User(username, "test");
		Mockito.when(userDao.findByUsername(username)).thenReturn(mockUser);

		// call the method that we're testing
		User returnedUser = userServ.logIn(username, password);

		// assertion (checking for expected behavior)
		assertNull(returnedUser);
	}

}