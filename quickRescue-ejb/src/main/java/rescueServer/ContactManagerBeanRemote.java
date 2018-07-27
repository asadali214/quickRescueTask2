package rescueServer;

import java.util.ArrayList;

import javax.ejb.Remote;

import entities.Contact;

@Remote
public interface ContactManagerBeanRemote {
	public ArrayList<Contact> viewAllContactsOfAccount(int AccountId);

	public int addContactinAccount(Contact contact, int AccountID);

	public Contact updateContactOfAccount(int ContactId, Contact contactNew);

	public void deleteContactOfAccount(int contactId);

	public void deleteAllContactsOfAccount(int AccountId);

	public Contact getContact(int id);
}
