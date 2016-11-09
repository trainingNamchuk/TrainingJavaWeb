package reflection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Svitlana Namchuk 08.11.16
 *
 */
public class DateUser {
	private String currentDate;

	public String getCurrentDate() {
		return currentDate;
	}

	public DateUser() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM");
		this.currentDate = dateFormat.format(date);
	}

}
