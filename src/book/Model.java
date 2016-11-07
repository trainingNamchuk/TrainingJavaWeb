package book;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Svitlana Namchuk 06.11.16
 *
 */

public class Model {
	private String firstname;
	private String lastname;
	private String middlename;
	private StringBuilder nickname;
	private String comment;

	private enum Group {
		Familly, Friends, Collegues, Others
	};

	private Group group;
	private String homePhoneNumber;
	private String cellPhoneNumber;
	private String cellPhoneNumber2;
	private String email;
	private String skype;
	private String postcode;
	private String city;
	private String street;
	private String houseNumber;
	private String flatNumber;
	private StringBuilder address;
	private String currentDate;
	private Map<Integer, String> record = new LinkedHashMap<>();
	private int counter = 0;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getNickname() {
		return nickname.toString();
	}

	/**
	 * Method for setting nickname. Format: lastname first letter of firstname.
	 */
	public void setNickname() {
		this.nickname = new StringBuilder(getLastname().subSequence(0, getLastname().length()));
		this.nickname = nickname.append(" ");
		this.nickname = nickname.append(getFirstname().charAt(0));
		this.nickname = nickname.append(".");
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	/**
	 * Method for setting address. Format: postcode city street ¹ house
	 * ¹appartament.
	 */
	public void setAddress() {
		this.address = new StringBuilder(getPostcode().subSequence(0, getPostcode().length()));
		this.address = address.append(" ");
		this.address = address.append(getCity());
		this.address = address.append(" street");
		this.address = address.append(getStreet());
		this.address = address.append(" ");
		this.address = address.append(getHouseNumber());
		this.address = address.append(" app.");
		this.address = address.append(getFlatNumber());
		this.address = address.append(".");
	}

	public String getAddress() {
		return this.address.toString();
	}

	public void setGroup(String group) {
		this.group = Group.valueOf(group);
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public void setCellPhoneNumber2(String cellPhoneNumber2) {
		this.cellPhoneNumber2 = cellPhoneNumber2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public Map<Integer, String> getRecord() {
		return record;
	}

	/**
	 * Method for setting Record
	 * 
	 */
	public void setRecord() {
		counter++;
		this.record.put(counter, toString());
	}

	@Override
	public String toString() {
		return " Firstname: " + firstname + "\n Lastname: " + lastname + "\n Middlename: " + middlename
				+ "\n Nickname: " + nickname + "\n Comment: " + comment + "\n Group: " + group
				+ "\n Home phone number: " + homePhoneNumber + "\n Cell phone number: " + cellPhoneNumber
				+ "\n Cell phone number2: " + cellPhoneNumber2 + "\n E-mail: " + email + "\n Skype: " + skype
				+ "\n Address: " + address + "\n Was added: " + currentDate + "\n";
	}
}
