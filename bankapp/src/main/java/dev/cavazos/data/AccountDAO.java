<<<<<<< HEAD
package dev.cavazos.data;

import dev.cavazos.ds.List;
import dev.cavazos.models.Account;

public interface AccountDAO extends DataAccessObject<Account> {
	public List<Account> findByStatus(String status);
}
=======
package dev.cavazos.data;

import dev.cavazos.ds.List;
import dev.cavazos.models.Account;

public interface AccountDAO extends DataAccessObject<Account> {
	public List<Account> findByStatus(String status);
}
>>>>>>> 94179b20c88ec075cfeb65b45e1b379100717a22
