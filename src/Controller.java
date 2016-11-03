import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Svitlana Namchuk on 02.11.2016.
 */
public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Method that run game
	 */
	@SuppressWarnings("resource")
	public void startGame() {
		int userNum = -1;
		view.printMessage(View.CHANGE_BARRIER); 
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		if (s.equals("Y")) {
			view.printMessage(View.INPUT_MIN_BARRIER);
			try {
				Scanner scanBarrier = new Scanner(System.in);
				int minBarrier = scanBarrier.nextInt();
				view.printMessage(View.INPUT_MAX_BARRIER);
				int maxBarrier = scanBarrier.nextInt();
				model.setNewBarriers(minBarrier, maxBarrier);
			} catch (InputMismatchException e) {
				view.printMessage(View.WRONG_INPUT);
			}
			Model.rand(Model.getMin(), Model.getMax());
		}
		view.printMessage(View.INPUT);
		// JUNIT MODEL+MAVEN
		// (POM.XML) + GITHUB
		while (Model.isGuessed(userNum) != true) {
			try {
				Scanner scan2 = new Scanner(System.in);
				userNum = scan2.nextInt();
			} catch (InputMismatchException e) {
				view.printMessage(View.WRONG_INPUT);
			}
			Model.addStatistics(userNum);
			if (Model.isBigger(userNum) != true) {
				view.printMessage(View.NUMBER_IS_BIGGER + "" + userNum);
				view.printMessage(View.RANGE_FROM + "" + Model.getMin() + "" + View.RANGE_TO + "" + Model.getMax());
			}
			if (Model.isBigger(userNum)) {
				view.printMessage(View.NUMBER_IS_SMALLER + "" + userNum);
				view.printMessage(View.RANGE_FROM + "" + Model.getMin() + " " + View.RANGE_TO + " " + Model.getMax());
			}
		}
		view.printResult(Model.getStatistics());

	}

}
