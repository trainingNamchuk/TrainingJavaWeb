package reflection;

import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Test;

/**
 * 
 * @author Svitlana Namchuk 08.11.16
 *
 */

public class ReflectionCheck {
	private Class aclass;

	/**
	 * Method that prints out the name of class
	 * 
	 * @param record
	 *            class object
	 */
	public void showClassName(Notebook record) {
		aclass = record.getClass();
		System.out.println("The name of class is: " + aclass.getName());
	}

	/**
	 * Method that prints out the modifier of class
	 */
	public void showClassModifier() {
		int mods = aclass.getModifiers();
		System.out.print("The modifier of class is: ");
		if (Modifier.isPublic(mods)) {
			System.out.println("public");
		}
		if (Modifier.isAbstract(mods)) {
			System.out.println("abstract");
		}
		if (Modifier.isFinal(mods)) {
			System.out.println("final");
		}
	}
	

	/**
	 * Method that prints out the parameters of class constructor
	 */
	@SuppressWarnings("rawtypes")
	public void showConstrParams() {
		Constructor[] constructors = aclass.getConstructors();
		for (Constructor constructor : constructors) {
			Class[] paramTypes = constructor.getParameterTypes();
			System.out.print("The constructor`s parametrs are: ");
			for (Class paramType : paramTypes) {
				System.out.print(paramType.getName() + " ");
			}
		}
	}

}
