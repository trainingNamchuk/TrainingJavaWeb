import java.util.ArrayList;

/**
 * Created by Svitlana Namchuk on 02.11.2016.
 */

public class View {
	// Text's constants
	public static final String GREETING = "Welcome to the game!\nWe have picked a number between 0 and 100, try to guess it, we wish you good luck!;)";
	public static final String CHANGE_BARRIER = "If you want to set your own barriers press Y, otherwise N";
	public static final String INPUT = "Please, enter your number";
	public static final String INPUT_MIN_BARRIER ="Enter min barrier";
	public static final String INPUT_MAX_BARRIER ="Enter max barrier";
	public static final String WRONG_INPUT = "Please, enter only integer numbers!";
	public static final String WRONG_RANGE_DATA = "Wrong range! Repeat please! ";
	public static final String NUMBER_IS_SMALLER = "The number is  smaller than ";
	public static final String NUMBER_IS_BIGGER = "The number is bigger than ";
	public static final String RANGE_FROM = "The number is in range from ";
	public static final String RANGE_TO = "...";
	public static final String CONGRATULATION = "Congratulations! You won!";
	public static final String STATISTICS = "N User_number From      To";

	View() {
		printMessage(GREETING);

	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Method for concatenation strings and printing them out
	 * 
	 * @param message
	 *            - from 1 to ...
	 */
	public void printMessage(String... message) {
		StringBuilder concatString = new StringBuilder();
		for (String v : message) {
			concatString = concatString.append(v);
		}
		printMessage(new String(concatString));
	}

	/**
	 * Method for printing user`s statistic
	 * 
	 * @param statistics
	 *            ArraList for output
	 */
	public void printResult(ArrayList<Integer> statistics) {
		System.out.println(STATISTICS);
		for (int i = 0; i < statistics.size(); i += 4) {
			System.out.println(statistics.get(i) + "\t" + statistics.get((i + 1)) + "\t" + statistics.get((i + 2))
					+ "\t" + statistics.get((i + 3)));
		}
	}
}
