package dk.nordea;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This is a parameterized class which is in charge of checking if all the
 * exceptions which are except from the code throw properly or not. this class
 * is parameterized to pass a collections of different data to methods and
 * define what kind of exception class are expected.
 *
 * @author Azin
 */
@RunWith(value = Parameterized.class)
public class TextFormatterExceptionText {

	/**
	 * To define what kind of exception is expected.
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 *
	 * Two different exceptions are expected in program.
	 * <p>
	 * 1)nullPointerException :
	 * {@link com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#IS_NULL}
	 * <p>
	 * 2)illegalArgumentException
	 * {@link com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#NOT_TRIANGLE}
	 * ,or
	 * {@link com.tradeshift.triangle.test.TriangleExceptionTest.ExceptionType#NOT_POSITIVE}
	 * .
	 */
	public enum ExceptionType {

		/**
		 * At least one of sides has not positive value
		 */
		OUT_OF_RANGE, 
		
		NOT_POSITIVE,

		/**
		 * At least one of sides has null value
		 */
		IS_NULL
	};

	public final ExceptionType exceptionType;

	private final Integer alignment, width;
	private final String text;

	/**
	 * The type of exception class which are expected as a result of the method
	 * under test.
	 */
	public Class<? extends Exception> expectedResultException;

	/**
	 *
	 * @param exceptionType
	 *            to determine what collections of data should pass to a certain
	 *            test method
	 * @param sideA
	 *            side A of triangle
	 * @param sideB
	 *            side B of triangle
	 * @param sideC
	 *            side C of triangle
	 * @param expectedResultException
	 *            exception class we are expected to be return by the method
	 *            under test
	 */
	public TextFormatterExceptionText(ExceptionType exceptionType, Integer alignment, Integer width, String text,
			Class<? extends Exception> expectedResultException) {
		this.exceptionType = exceptionType;
		this.alignment = alignment;
		this.width = width;
		this.text = text;
		this.expectedResultException = expectedResultException;
	}

	/**
	 *
	 * @return collections of data base on different ExceptionType and expected
	 *         exception class as a result of the under test method.
	 */
	@Parameterized.Parameters()
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
						{ ExceptionType.IS_NULL, null, 5, "test", NullPointerException.class },
						{ ExceptionType.IS_NULL, 2 ,null, "test", NullPointerException.class },
						{ ExceptionType.OUT_OF_RANGE, -1, 5, "test", IllegalArgumentException.class },
						{ ExceptionType.NOT_POSITIVE, -1, 2, "test", IllegalArgumentException.class },
						{ ExceptionType.NOT_POSITIVE, 1, -5, "test", IllegalArgumentException.class },
						{ ExceptionType.OUT_OF_RANGE, 7, 5, "test", IllegalArgumentException.class }, });

	}

	/**
	 * Check {@link com.tradeshift.triangle.Triangle#isNotPositive()}if create
	 *
	 * @throw IllegalArgumentException.class in case having any zero or negative
	 *        sides
	 */
	@Test()
	public void notPositiveSideShouldThrowIllegalArgumentException() {
		Assume.assumeTrue(exceptionType == ExceptionType.NOT_POSITIVE);
		if (expectedResultException != null) {
			exception.expect(expectedResultException);
		}
		assertEquals(alignment + "," + width + "should not be negetive!!", expectedResultException,
				new TextFormatter(alignment, width, text));

	}

	/**
	 * Check if {@link com.tradeshift.triangle.Triangle#isAnySideNull()} create
	 *
	 * @throw IllegalArgumentException in case having any null sides
	 *
	 */
	
	@Test()
	public void nullInputShouldThrowNullPointerException() {
		Assume.assumeTrue(exceptionType == ExceptionType.IS_NULL);
		if (expectedResultException != null) {
			exception.expect(expectedResultException);
		}
		assertEquals(alignment + "," + width + "should not be null!!", expectedResultException,
				new TextFormatter(alignment, width, text));

	}

	
	@Test()
	public void outOFRangeInputShouldThrowIllegalArgumentException() {
		Assume.assumeTrue(exceptionType == ExceptionType.IS_NULL);
		if (expectedResultException != null) {
			exception.expect(expectedResultException);
		}
		assertEquals(alignment +  "should not be out of range 0-6!!", expectedResultException,
				new TextFormatter(alignment, width, text));

	}

}
