package rescueServer;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Account;

/**
 * Session Bean implementation class AccountManagerBean
 */
@Stateless
@LocalBean
public class AccountManagerBean implements AccountManagerBeanRemote {

    /**
     * Default constructor. 
     */
    public AccountManagerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Account> viewAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account updateAccount(int id, Account accountNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
