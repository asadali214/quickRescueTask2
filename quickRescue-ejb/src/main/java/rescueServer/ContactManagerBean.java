package rescueServer;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
    	System.out.println("Contact Constructor Called!");
    }

	@Override
	public ArrayList<Object> viewAllContactsOfAccount(int AccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addContactinAccount(Object contact, int AccountID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object updateContactOfAccount(int ContactId, Object contactNew) {
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
	public Object getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
