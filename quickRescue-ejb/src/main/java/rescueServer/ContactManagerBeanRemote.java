package rescueServer;

import java.util.ArrayList;

import javax.ejb.Remote;


@Remote
public interface ContactManagerBeanRemote {
	public ArrayList<Object> viewAllContactsOfAccount(int AccountId);

	public int addContactinAccount(Object contact, int AccountID);

	public Object updateContactOfAccount(int ContactId, Object contactNew);

	public void deleteContactOfAccount(int contactId);

	public void deleteAllContactsOfAccount(int AccountId);

	public Object getContact(int id);
}
