package rescueClient;

import java.util.ArrayList;

import entities.Account;
import entities.Contact;
import rescueServer.AccountManagerBean;
import rescueServer.AccountManagerBeanRemote;
import rescueServer.AlertProManagerBean;
import rescueServer.AlertProManagerBeanRemote;
import rescueServer.ContactManagerBean;
import rescueServer.ContactManagerBeanRemote;

public class RescueServices {
	private static AccountManagerBeanRemote accountBean;
	private static ContactManagerBeanRemote contactBean;
	private static AlertProManagerBeanRemote alertBean;

	private RescueServices() {
		try {
			accountBean = (AccountManagerBeanRemote) ServiceManager.getService(AccountManagerBean.class);
			contactBean = (ContactManagerBeanRemote) ServiceManager.getService(ContactManagerBean.class);
			alertBean = (AlertProManagerBeanRemote) ServiceManager.getService(AlertProManagerBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Account> viewAllAccounts() {
		return accountBean.viewAllAccounts();
	}

	public static int addNewAccount(Account account) {
		return accountBean.addNewAccount(account);
	}

	public static Account updateAccount(int id, Account accountNew) {
		return accountBean.updateAccount(id, accountNew);
	}

	public static void deleteAccount(int id) {
		accountBean.deleteAccount(id);
	}
	
	public static Account getAccount(int id) {
		return accountBean.getAccount(id);
	}

	public static ArrayList<Contact> viewAllContactsOfAccount(int AccountId) {
		return contactBean.viewAllContactsOfAccount(AccountId);
	}

	public static int addContactinAccount(Contact contact, int AccountID) {
		return contactBean.addContactinAccount(contact, AccountID);
	}

	public static Contact updateContactOfAccount(int ContactId, Contact contactNew) {
		return contactBean.updateContactOfAccount(ContactId, contactNew);
	}

	public static void deleteContactOfAccount(int contactId) {
		contactBean.deleteContactOfAccount(contactId);

	}

	public static void deleteAllContactsOfAccount(int AccountId) {
		contactBean.deleteAllContactsOfAccount(AccountId);
	}

	public static Contact getContact(int id) {
		return contactBean.getContact(id);
	}
	public static void setUpServices() {
		new RescueServices();//this will get all the beans 
		System.out.println("Got all the beans! ");
	}

	public static void main(String[] args) {
		int resultedID = accountBean.addNewAccount(null);
		System.out.println("main: gotten account id is " + resultedID);
	}
}
