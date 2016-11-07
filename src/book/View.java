package book;

import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Svitlana Namchuk 06.11.16
 *
 */

public class View {
	// Text's constants
	public static final String GREETING = "Welcome! Please, choose what do you want to do:";
	public static final String USERS_MENU = "1. Add new contact.\n2. Print contacts.\n3. Exit.";
	public static final String WRONG_MENU = "Wrong menu item! Please, try again!";
	public static final String NO_RECORDS = "No records! Please, add contact first!";
	public static final String TYPE_FIRSTNAME = "Please, type firstname.";
	public static final String WRONG_INPUT = "Wrong input! Please, try again!";
	public static final String TYPE_LASTNAME = "Please, type lastname.";
	public static final String TYPE_MIDDLENAME = "Please, type middlename.";
	public static final String NICKNAME = "The nickname is: ";
	public static final String TYPE_COMMENT = "If you do not want to type any comments, please, press enter.";
	public static final String TYPE_GROUP = "Please, type group: Familly, Friends, Collegues, Others.";
	public static final String TYPE_PHONE_NUMBER = "Please, type cell number. Format: 0634534308";
	public static final String TYPE_HOME_PHONE_NUMBER = "Please, type home phone number. Format: 4234252";
	public static final String TYPE_PHONE_NUMBER2 = "If you do not want to type second cell number, please, press enter. Format: 0634534308";
	public static final String TYPE_EMAIL = "Please, type email.";
	public static final String TYPE_SKYPE = "Please, type skype.";
	public static final String TYPE_POSTCODE = "Please, type postcode.";
	public static final String TYPE_CITY = "Please, type city.";
	public static final String TYPE_STREET = "Please, type street.";
	public static final String TYPE_HOUSE_NUMBER = "Please, type house number.";
	public static final String TYPE_FLAT_NUMBER = "Please, type flat number.";
	public static final String ADDRESS = "The address is: ";
	public static final String SAVED = "New contact was saved!\n";
	public static final String CURRENT_DATE = "Please, type current date! Format: dd/mm/yyyy";

	/**
	 * Method for printing message
	 * 
	 * @param message
	 */

	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Method for printing out contact`s information
	 * 
	 * @param map
	 */
	public void printRecord(Map<Integer, String> map) {
		for (Entry<Integer, String> e : map.entrySet()) {

			System.out.println(e.getKey() + ".\n" + e.getValue());
		}
	}
}
