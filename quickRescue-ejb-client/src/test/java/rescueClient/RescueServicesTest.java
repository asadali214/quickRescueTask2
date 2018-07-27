package rescueClient;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import entities.Account;
import entities.Address;
import entities.Contact;

public class RescueServicesTest {

	Account dummyAccount1 = new Account("NatGeo", "@natgeo.com", "Berlin");

	Address dummyAddress1 = new Address("St#03", "Islamabad", "Punjab", "Pakistan");
	Address dummyAddress2 = new Address("St#05", "Rawalpindi", "Punjab", "Pakistan");

	Contact dummyContact1 = new Contact("Asad", "Ali", "14asadali@icloud.com", "Male", "0311-5171363", true,
			dummyAddress1);
	Contact dummyContact2 = new Contact("Arya", "Asad", "arya@got.com", "Female", "0765-9333908", false, dummyAddress2);
	
	/*
	 * setUpClass is called once
	 */
	@BeforeClass
	public static void setUpClass() {
	    RescueServices.setUpServices();
	}

	/*
	 * It first add an account in DB and then match its id with expected id In the
	 * end we are also removing the inserted account
	 */
	@Test
	public void testAddNewAccount() {// dependent on getAccount(id)
		
		int OutputId = RescueServices.addNewAccount(dummyAccount1);
		Account account = RescueServices.getAccount(OutputId);
		int expectedId = account.getId();
		assertEquals(expectedId, OutputId);
		RescueServices.deleteAccount(OutputId);
	}

	/*
	 * It first insert dummyData into the DB then get the array list of output by
	 * calling viewAllAccounts then first compare size of expected and resultant
	 * arrayLists Then it also check the complete ArrayList by comparing its
	 * elements and their properties.
	 */
	@Test
	public void testViewAllAccounts() {// dependent on addNewAccount()
		
		insertDummyData();
		ArrayList<Account> output = RescueServices.viewAllAccounts();
		ArrayList<Account> expected = new ArrayList<Account>();
		expected.add(dummyAccount1);
		assertEquals(expected.size(), output.size());
		for (int i = 0; i < output.size(); i++) {
			assertEquals(expected.get(i).getId(), output.get(i).getId());
			assertEquals(expected.get(i).getName(), output.get(i).getName());
			assertEquals(expected.get(i).getEmailDomain(), output.get(i).getEmailDomain());
			assertEquals(expected.get(i).getTimeZoneCity(), output.get(i).getTimeZoneCity());
		}
		deleteDummyData();

	}

	/*
	 * It tests the updateAccount method by matching the updated/edited properties
	 * of NewAccount and updatedAccount
	 */
	@Test
	public void testUpdateAccount() {// addNewAccount(), viewAllAccount()
		insertDummyData();

		Account accountNew = new Account();
		accountNew.setTimeZoneCity("Karachi");
		Account accountUpdated = RescueServices.updateAccount(dummyAccount1.getId(), accountNew);

		String expected = accountNew.getTimeZoneCity();
		String output = accountUpdated.getTimeZoneCity();
		assertEquals(expected, output);

		deleteDummyData();

	}

	/*
	 * It compares the size of the table account after deletion with its expected
	 * size it also compares the size of contacts after deletion of an account As
	 * removing an account should also remove all the contacts too
	 */
	@Test
	public void testDeleteAccount() {// dependent on addNewAccount(), addNewContact(), viewAllAccounts(),
		// viewAllContacts()
		insertDummyData();
		Account account = RescueServices.getAccount(1);
		int accountsizeBeforeDeletionExpected = RescueServices.viewAllAccounts().size() - 1;
		int contactsizeBeforeDeletionExpected = 0;// 0 for that account
		RescueServices.deleteAccount(dummyAccount1.getId());
		int accountsizeAfterDeletionActual = RescueServices.viewAllAccounts().size();
		int contactsizeAfterDeletionActual = RescueServices.viewAllContactsOfAccount(account.getId()).size();

		assertEquals(accountsizeBeforeDeletionExpected, accountsizeAfterDeletionActual);
		assertEquals(contactsizeBeforeDeletionExpected, contactsizeAfterDeletionActual);

	}

	/*
	 * It first insert dummyData into the DB then get the array list of output by
	 * calling viewAllContacts then it compares the size of expected and resultant
	 * arrayLists
	 */
	@Test
	public void testViewAllContactsOfAccount() {
		insertDummyData();
		ArrayList<Contact> output = RescueServices.viewAllContactsOfAccount(dummyAccount1.getId());
		ArrayList<Contact> expected = new ArrayList<Contact>();
		expected.add(dummyContact1);
		expected.add(dummyContact2);

		assertEquals(expected.size(), output.size());

		deleteDummyData();
	}

	/*
	 * It first add an account in DB and then a contact against that account then
	 * match contact's id with its expected id In the end we are also removing the
	 * inserted account
	 */
	@Test
	public void testAddContactinAccount() {
		RescueServices.addNewAccount(dummyAccount1);
		int OutputId = RescueServices.addContactinAccount(dummyContact1, dummyAccount1.getId());
		Contact contact = RescueServices.getContact(OutputId);
		int expectedId = contact.getId();
		assertEquals(expectedId, OutputId);
		RescueServices.deleteAccount(dummyAccount1.getId());

	}

	/*
	 * It tests the updateContact method by matching the updated/edited properties
	 * of NewContact and updatedContact it also check if address of a contact is
	 * updated or not
	 */
	@Test
	public void testUpdateContactOfAccount() {
		insertDummyData();

		Contact contactNew = new Contact();
		Address addressNew = new Address();
		contactNew.setEmailAddress("aali@globalrescue.com");
		addressNew.setStreetAddress("St#11");
		contactNew.setAddress(addressNew);

		Contact contactUpdated = RescueServices.updateContactOfAccount(dummyContact2.getId(), contactNew);
		String expected = contactNew.getEmailAddress();
		String output = contactUpdated.getEmailAddress();
		assertEquals(expected, output);
		expected = contactNew.getAddress().getStreetAddress();
		output = contactUpdated.getAddress().getStreetAddress();
		assertEquals(expected, output);

		deleteDummyData();
	}

	/*
	 * This test first add a dummy account and two contacts into the DB then it
	 * deletes one contact and check if the size of contact table is 1 or not In the
	 * end we are also removing our dummy data from the database
	 */
	@Test
	public void testDeleteContactOfAccount() {
		insertDummyData();

		Contact contact = RescueServices.getContact(1);
		int contactsizeBeforeDeletionExpected = 1;// it will remain 1 for that account as we are deleting only 1 out of
													// 2 contacts
		RescueServices.deleteContactOfAccount(contact.getId());
		int contactsizeAfterDeletionActual = RescueServices.viewAllContactsOfAccount(contact.getAccount().getId())
				.size();
		assertEquals(contactsizeBeforeDeletionExpected, contactsizeAfterDeletionActual);

		deleteDummyData();
	}

	/*
	 * This test first add a dummy account and two contacts into the DB then it
	 * deletes both the contacts and check if the size of contact table is 0 or not
	 * In the end we are also removing our dummy data from the database
	 */
	@Test
	public void testDeleteAllContactsOfAccount() {
		insertDummyData();
		Account account = RescueServices.viewAllAccounts().get(0);

		int contactsizeBeforeDeletionExpected = 0;// 0 contacts for that account as we are deleting all the contacts
		RescueServices.deleteAllContactsOfAccount(account.getId());
		int contactsizeAfterDeletionActual = RescueServices.viewAllContactsOfAccount(account.getId()).size();

		assertEquals(contactsizeBeforeDeletionExpected, contactsizeAfterDeletionActual);
		deleteDummyData();
	}

	// inserts one account and two contacts as dummy data
	private void insertDummyData() {
		RescueServices.addNewAccount(dummyAccount1);
		RescueServices.addContactinAccount(dummyContact1, dummyAccount1.getId());
		RescueServices.addContactinAccount(dummyContact2, dummyAccount1.getId());

	}

	// delete the account results in deleting the contacts too
	// hence removing the dummy data
	private void deleteDummyData() {
		RescueServices.deleteAccount(dummyAccount1.getId());

	}
}
