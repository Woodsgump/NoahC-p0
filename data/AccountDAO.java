package dev.cavazos.data;

import dev.cavazos.models.Account;

public interface AccountDAO extends DataAccessObject<Account> {
	public Account findByID(int id);
}
