package dk.nordea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible to get 3 integer numbers from user as triangle's
 * sides, it will ignore all non integer values.
 *
 * @author Azin
 */
public class UserInput {

	public UserInput() {
	}

	/**
	 * it will get user's input, and count only first three numbers which user
	 * enter. it will ignore all letters or special characters. if input has
	 * less than 3 number , then NoSuchElementException catch in while loop.
	 *
	 * @return list of maximum three integer numbers of user inputs as a
	 *         triangle's sides.
	 * @exception InputMismatchException
	 *                if user enter non integer value
	 * @exception NoSuchElementException
	 *                if user does not enter enough number
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

	public String getTextInput() {
		System.out.println(" Enter the text ");
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			System.out.println(" text is readed : " + input);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
//		Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()) {
		return br.toString();
	}
}
