import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Svitlana Namchuk on 02.11.2016.
 */

public class Model implements GlobalConstants {
	private static int min = PRIMARY_MIN_BARRIER;
	private static int max = PRIMARY_MAX_BARRIER;
	static int randomNum = rand(min, max); // random number
	private static int attemptNum = 0; // attempt`s number
	static ArrayList<Integer> statistics = new ArrayList<>(); // hold user`s
																// statistics

	/**
	 * Method for creating random number
	 * 
	 * @param min
	 *            set an initial value of range
	 * @param max
	 *            set a final value of range
	 * @return random number
	 */
	public static int rand(int min, int max) {
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static int getMin() {
		return min;
	}

	public static int getMax() {
		return max;
	}

	public int changeRandomNum(int newRandom) {
		return randomNum = newRandom;
	}

	/**
	 * Method that sets new min and max barriers of range
	 * 
	 * @param newMin
	 *            new initial value of range
	 * @param newMax
	 *            new final value of range
	 */
	public void setNewBarriers(int newMin, int newMax) {
		if (newMin > newMax) {
			int tmp = newMax;
			newMax = newMin;
			newMin = tmp;
		}
		min = newMin;
		max = newMax;
	}

	/**
	 * Method for adding user`s statistic
	 * 
	 * @param userNum
	 *            integer user`s number
	 */
	public static void addStatistics(int userNum) {
		attemptNum++;
		statistics.add(attemptNum);
		statistics.add(userNum);
		statistics.add(min);
		statistics.add(max);
	}

	public static ArrayList<Integer> getStatistics() {

		return statistics;

	}

	/**
	 * Method that checks if user guessed number
	 * 
	 * @param userNum
	 *            integer user`s number
	 * @return true if user`s number equals random number
	 */
	public static boolean isGuessed(int userNum) {
		if (userNum == randomNum) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that checks if user number is bigger than random number. Also it
	 * sets new barriers of range
	 * 
	 * @param userNum
	 *            integer user`s number
	 * @return true if
	 */
	public static boolean isBigger(int userNum) {
		if (userNum > randomNum) {
			max = userNum;
			return true;
		} else
			min = userNum;
		return false;
	}
}
