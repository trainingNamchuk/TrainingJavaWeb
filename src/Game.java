/**
 * Created by Svitlana Namchuk on 02.11.2016.
 */
public class Game {

	public static void main(String[] args) {
		//Initialization
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		// Run
		controller.startGame();
	}
	
}
