import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
	Model model = new Model();

	@Test
	public void testRand() {
		int min = 0;
		int max = 100;
		int randNumber = Model.rand(min, max);
		if (randNumber < min && randNumber > max) {
			fail("The number is out of range!");
		}
	}

	@Test
	public void testSetNewBarriers() {
		int min = 100;
		int max = 0;
		model.setNewBarriers(min, max);
		if (Model.getMax() < Model.getMin()) {
			fail("No checks for extreme values of range!");
		}
	}

	@Test
	public void testIsGuessed() {
		int userNum = 10;
		int randomNum = 10;
		model.changeRandomNum(randomNum);
		if (Model.isGuessed(userNum) != true) {
			fail("Wrong method!");
		}
	}

	@Test
	public void testIsBigger() {
		int userNum = 10;
		int randomNum = 5;
		model.changeRandomNum(randomNum);
		if (Model.isBigger(userNum) != true) {
			fail("Wrong method!");
		}
	}
}