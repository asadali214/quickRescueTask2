package rescueServer;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Account;


/**
 * Session Bean implementation class AccountManagerBean
 */
@Stateless
@LocalBean
public class AccountManagerBean implements AccountManagerBeanRemote {

	//private SessionFactory factory;
    public AccountManagerBean() {
    	System.out.println("Account Constructor Called!");
    	//factory= SessionFactoryManager.getSessionfac();
    }
	@Override
	public ArrayList<Object> viewAllAccounts() {
		
		return null;
	}
	@Override
	public int addNewAccount(Object account) {
		System.out.println("session is called");
		
		return 0;
	}
	@Override
	public Object updateAccount(int id, Object accountNew) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
