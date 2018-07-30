package rescueServer;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface AccountManagerBeanRemote {
	public ArrayList<Object> viewAllAccounts();

	public int addNewAccount(Object account);

	public Object updateAccount(int id, Object accountNew);

	public void deleteAccount(int id);
	
	public Object getAccount(int id);
}
