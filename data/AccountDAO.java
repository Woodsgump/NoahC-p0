package dev.cavazos.data;

import dev.cavazos.models.Account;
/**
 * An Account DataAccessObject implementation for the following banking application program.
 * 
 * @author Noah Cavazos
 *
 */
public interface AccountDAO extends DataAccessObject<Account> {
	public Account findByID(int id);
}
