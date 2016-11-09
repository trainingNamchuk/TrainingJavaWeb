package reflection;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Svitlana Namchuk 08.11.16
 *
 */
public class Notebook extends DateUser {

	private String name;
	private String phoneNumber;
	private String birth;

	@Override
	public String toString() {
		return "name=" + name + ", phoneNumber=" + phoneNumber + ", birth=" + birth;
	}

	/**
	 * Method that counts the number of days before birthday
	 * 
	 * @return number of days before birthday
	 */
	@Check (author="S Namchuk")
	public long countDaysBeforeBday() {
		DateUser currentdate = new DateUser();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = format.parse(birth);
			date2 = format.parse(currentdate.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		long difference = date1.getTime() - date2.getTime();
		long days = difference / (24 * 60 * 60 * 1000);
		if (days <= 0) {
			days += 365;
		}
		return days;
	}

	public Notebook(String name, String phoneNumber, String birth) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}
}
