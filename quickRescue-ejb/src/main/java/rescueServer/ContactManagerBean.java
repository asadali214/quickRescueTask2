package rescueServer;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Contact;

/**
 * Session Bean implementation class ConatactManagerBean
 */
@Stateless
@LocalBean
public class ContactManagerBean implements ContactManagerBeanRemote {

    /**
     * Default constructor. 
     */
    public ContactManagerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Contact> viewAllContactsOfAccount(int AccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addContactinAccount(Contact contact, int AccountID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact updateContactOfAccount(int ContactId, Contact contactNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContactOfAccount(int contactId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllContactsOfAccount(int AccountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
