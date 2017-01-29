package dk.nordea.textformat;

import java.util.List;

/**
 * This program formats a text which is entered by user, it is also runnable from CMD. 
 * It takes Alignment and width due to formatting the text from user.
 * program formats the text in 5 different ways: LEFT_ALIGN, RIGHT_ALIGN, CENTER, JUSTIFY, WRAP.
 * @author Azin
 * @version 1.0 Build Jan, 29 , 2017.
 */

public class TextFormatterRunner {

	/**
     * get two integer numbers from User
     * ({@link  dk.nordea.textformat.TextFormater.UserInput#getFormatInputs }) and 
     * ({@link  dk.nordea.textformat.TextFormater.UserInput#getTextInput })
     * call formatting method:
     * ({@link  dk.nordea.textformat.TextFormatter#textFormatting()}). in case
     * 
     * @param args get two integer numbers from user. and a String for text.
     * @exception IllegalArgumentException 
     * @exception NullPointerException 
     * @exception IndexOutOfBoundsException can come from
     * ({@link dk.nordea.textformat.TextFormatter#textFormatting()}) due to its parameters. 
     */
	public static void main(String[] args) {
		UserInput userInput = new UserInput();
		List<Integer> formattingInputs = userInput.getFormatInputs();
		String textInput = userInput.getTextInput();
		try {
			TextFormatter textFormatter = new TextFormatter(formattingInputs.get(0), formattingInputs.get(1),
					textInput);
			textFormatter.textFormatting();
		} 
		
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Alignment is out of bound !!" + ex.getMessage());

		}
		catch (IllegalArgumentException ex) {
			System.out.println("Width should not be negetive !!" + ex.getMessage());

		} catch (NullPointerException ex) {
			System.out.println("Alignment and witdh should not be null !!" + ex.getMessage());

		}

	}
}