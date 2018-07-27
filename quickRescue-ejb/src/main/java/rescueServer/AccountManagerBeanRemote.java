package rescueServer;

import java.util.ArrayList;

import javax.ejb.Remote;

import entities.Account;

@Remote
public interface AccountManagerBeanRemote {
	public ArrayList<Account> viewAllAccounts();

	public int addNewAccount(Account account);

	public Account updateAccount(int id, Account accountNew);

	public void deleteAccount(int id);
	
	public Account getAccount(int id);
}
