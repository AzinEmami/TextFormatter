package dk.nordea.textformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible to get 2 integer numbers from user as Alignment and
 * width. and also get text need to be formatted from input.
 *
 * @author Azin
 */
public class UserInput {

	public UserInput() {
	}

	public String getTextInput() {
		System.out.println(" Enter the text ");
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		String inputText = "";
		try {
			inputText = br.readLine();

		} catch (IOException e) {
			System.out.println(e);
		}
		return inputText;
	}

	/**
	 *
	 * @return list of alignment and width.
	 * @exception InputMismatchException
	 *                if user enter non integer value
	 * 
	 */
	public List<Integer> getFormatInputs() {
		List<Integer> formatInputs = new ArrayList<Integer>();

		Scanner userInputs = new Scanner(System.in);

		int count = 0;
		while (count < 1) {

			try {
				System.out.println(" Enter the number in front of alignment which is desired: ");
				System.out.println("LEFT_ALIGN(1), RIGHT_ALIGN(2), CENTER(3), JUSTIFY(4), WRAP(5), HARD(6)");
				formatInputs.add(userInputs.nextInt());
				count++;
			} catch (InputMismatchException e) {
				System.out.println(userInputs.next() + " is not a valid number !!");

			}

		}

		count = 0;
		while (count < 1) {

			try {
				System.out.println(" Enter width: ");
				formatInputs.add(userInputs.nextInt());
				count++;

			} catch (InputMismatchException e) {
				System.out.println(userInputs.next() + " is not a valid number !!");

			}
		}

		System.out.println(" user has entered : " + formatInputs);
		return formatInputs;
	}

}
