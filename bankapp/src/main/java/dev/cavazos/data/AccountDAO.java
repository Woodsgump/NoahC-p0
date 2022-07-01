package dev.cavazos.data;

import dev.cavazos.ds.List;
import dev.cavazos.models.Account;

public interface AccountDAO extends DataAccessObject<Account> {
	public List<Account> findByStatus(String status);
}
