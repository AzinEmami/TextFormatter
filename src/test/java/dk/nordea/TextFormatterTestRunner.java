package dk.nordea;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 * This class is responsible for running all the test classes which are related
 * to Triangle project. it has Suite classes which contains all the test classes
 * name.
 *
 * @author Azin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TextFormatterExceptionText.class, TextFormatterTest.class, UserInputTest.class })
public class TextFormatterTestRunner {

	/**
	 * main method to run JunitCore to run the Suite class. it will print out
	 * all the test which might be failed or print out "true" in case all the
	 * test will be passed successfully.
	 *
	 * @param args
	 *            get 3 test classes name from SuiteClasses
	 */
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TextFormatterTestRunner.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
