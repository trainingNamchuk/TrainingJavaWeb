package book;

/**
 * 
 * @author Svitlana Namchuk 06.11.16
 *
 */

public class Notebook {

	public static void main(String[] args) {
		// Initialization
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		// Run
		controller.runMenu();

	}

}
