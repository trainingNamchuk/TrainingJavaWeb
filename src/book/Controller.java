package book;

import java.util.regex.*;

import java.util.Scanner;

/**
 * 
 * @author Svitlana Namchuk 06.11.16
 *
 */

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		view.printMessage(View.GREETING);
	}

	/**
	 * Method for running user`s menu
	 */
	@SuppressWarnings("resource")
	public void runMenu() {
		view.printMessage(View.USERS_MENU);
		Scanner scan = new Scanner(System.in);
		String menu = scan.nextLine();
		while (menu.length() != 1 || checkMenu(menu) == 0) {
			view.printMessage(View.WRONG_MENU);
			menu = scan.nextLine();
		}

	}

	/**
	 * Method for checking correct of chosen item
	 * 
	 * @param menu
	 *            chosen item
	 * @return menu item
	 */

	public int checkMenu(String menu) {
		int choice = 0;
		switch (menu.charAt(0)) {
		case '1':
			choice = 1;
			addContact();
			return choice;
		case '2':
			choice = 2;
			if (!model.getRecord().isEmpty()) {
				view.printRecord(model.getRecord());
				runMenu();
			} else {
				view.printMessage(View.NO_RECORDS);
				runMenu();
			}
			return choice;
		case '3':
			choice = 3;
			return choice;
		default:
			return choice;

		}
	}

	/**
	 * Method for checking correct of string such as first/last/middle name,
	 * street, city etc
	 * 
	 * @param name
	 * @return true if correct
	 */
	public boolean checkString(String name) {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(name);
		return m.matches();
	}

	/**
	 * Method for checking correct of group name
	 * 
	 * @param group
	 * @return true if correct
	 */
	public boolean checkGroup(String group) {
		Pattern p = Pattern.compile("Familly|Friends|Collegues|Others");
		Matcher m = p.matcher(group);
		return m.matches();
	}

	/**
	 * Method for checking correct of phone home number
	 * 
	 * @param number
	 * @return true if correct
	 */
	public boolean checkPhoneHomeNumber(String number) {
		Pattern p = Pattern.compile("[1-9]{1}[0-9]{6}");
		Matcher m = p.matcher(number);
		return m.matches();
	}

	/**
	 * Method for checking correct of cell number
	 * 
	 * @param number
	 * @return true if correct
	 */
	public boolean checkCellNumber(String number) {
		Pattern p = Pattern.compile("\\d{10}");
		Matcher m = p.matcher(number);
		return m.matches();
	}

	/**
	 * Method for checking correct of email
	 * 
	 * @param email
	 * @return true if correct
	 */
	public boolean checkEmail(String email) {
		Pattern p = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * Method for checking correct of number such as flat number, house number
	 * 
	 * @param number
	 * @return true if correct
	 */
	public boolean checkNumber(String number) {
		Pattern p = Pattern.compile("[1-9]{1}[0-9 a-zA-Z]*");
		Matcher m = p.matcher(number);
		return m.matches();
	}

	/**
	 * Method for checking correct of postcode number
	 * 
	 * @param number
	 * @return true if correct
	 */

	public boolean checkPostcode(String number) {
		Pattern p = Pattern.compile("\\d{5}");
		Matcher m = p.matcher(number);
		return m.matches();
	}

	/**
	 * Method for checking correct of current date
	 * 
	 * @param date
	 * @return true if correct
	 */
	private boolean checkDate(String date) {
		Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Matcher m = p.matcher(date);
		return m.matches();
	}

	/**
	 * Method for adding new contact
	 */
	@SuppressWarnings("resource")
	public void addContact() {
		view.printMessage(View.TYPE_LASTNAME);
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		while (!checkString(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setLastname(str);
		view.printMessage(View.TYPE_FIRSTNAME);
		str = scan.nextLine();
		while (!checkString(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setFirstname(str);
		view.printMessage(View.TYPE_MIDDLENAME);
		str = scan.nextLine();
		while (!checkString(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setMiddlename(str);
		model.setNickname();
		view.printMessage(View.TYPE_COMMENT);
		str = scan.nextLine();
		model.setComment(str);
		view.printMessage(View.TYPE_GROUP);
		str = scan.nextLine();
		while (!checkGroup(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setGroup(str);
		view.printMessage(View.TYPE_HOME_PHONE_NUMBER);
		str = scan.nextLine();
		while (!checkPhoneHomeNumber(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setHomePhoneNumber(str);
		view.printMessage(View.TYPE_PHONE_NUMBER);
		str = scan.nextLine();
		while (!checkCellNumber(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setCellPhoneNumber(str);

		view.printMessage(View.TYPE_PHONE_NUMBER2);
		str = scan.nextLine();
		if (str.length() > 0) {
			while (!checkCellNumber(str)) {
				view.printMessage(View.WRONG_INPUT);
				str = scan.nextLine();
			}
			model.setCellPhoneNumber2(str);
		} else {
			str = "";
			model.setCellPhoneNumber2(str);
		}
		view.printMessage(View.TYPE_EMAIL);
		str = scan.nextLine();
		while (!checkEmail(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setEmail(str);
		view.printMessage(View.TYPE_SKYPE);
		str = scan.nextLine();
		while (str.length() == 0) {
			view.printMessage(View.TYPE_SKYPE);
			str = scan.nextLine();
		}
		model.setSkype(str);
		view.printMessage(View.TYPE_POSTCODE);
		str = scan.nextLine();
		while (!checkPostcode(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setPostcode(str);
		view.printMessage(View.TYPE_CITY);
		str = scan.nextLine();
		while (!checkString(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setCity(str);
		view.printMessage(View.TYPE_STREET);
		str = scan.nextLine();
		while (!checkString(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setStreet(str);
		view.printMessage(View.TYPE_HOUSE_NUMBER);
		str = scan.nextLine();
		while (!checkNumber(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setHouseNumber(str);
		view.printMessage(View.TYPE_FLAT_NUMBER);
		str = scan.nextLine();
		while (!checkNumber(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setFlatNumber(str);
		model.setAddress();
		view.printMessage(View.CURRENT_DATE);
		str = scan.nextLine();
		while (!checkDate(str)) {
			view.printMessage(View.WRONG_INPUT);
			str = scan.nextLine();
		}
		model.setCurrentDate(str);
		model.setRecord();
		view.printMessage(View.SAVED);
		// view.printMessage(model.toString());
		runMenu();
	}
}
