package reflection;

/**
 * 
 * @author Svitlana Namchuk 08.11.16
 *
 */
public class Main {
	public static void main(String[] args) {
		Notebook record = new Notebook("Alex", "5462822", "19.11");
		System.out.println("Days before birthday: " + record.countDaysBeforeBday());
		System.out.println("Contact`s data is: " + record.toString());
		ReflectionCheck ref = new ReflectionCheck();
		ref.showClassName(record);
		ref.showClassModifier();
		ref.showConstrParams();
		/*
		 * Class<?> mc; try { mc = Class.forName("reflection.Notebook");
		 * Method[] publicMethods = mc.getMethods(); for (Method method :
		 * publicMethods) { int mods = method.getModifiers(); Annotation[]
		 * annotations = method.getAnnotations();
		 * 
		 * System.out.println("\n  PUBLIC METHODS are " + method.getName() +
		 * " mods=" + Modifier.toString(mods) + " retType=" +
		 * method.getReturnType() + " annotation=" +
		 * Arrays.toString(annotations)); }
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

	}
}
