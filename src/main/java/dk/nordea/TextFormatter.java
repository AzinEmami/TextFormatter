package dk.nordea;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class TextFormatter {

	public enum AligmentEnum {
		LEFT_ALIGN(1), RIGHT_ALIGN(2), CENTER(3), JUSTIFY(4), WRAP(5), HARD(6);

		private final int value;

		AligmentEnum(final int newValue) {
			this.value = newValue;
		}

		public int getValue() {
			return value;
		}
	}

	private final Integer alignment, width;
	public static final int LENGHT_OF_WRAP = 20;

	private final String text;

	public TextFormatter(Integer alignment, Integer width, String text) {

		this.alignment = alignment;
		this.width = width;
		this.text = text;

		if (isAlignmentORWidthNull()) {
			throw new NullPointerException("None of the sides can be null!!");
		}

		if (isAlignmentOutofRange()) {
			throw new IllegalArgumentException("  each must be greater than zero.");

		}

		if (isAlignmentORWidthNegetive()) {
			throw new IllegalArgumentException("  each must be greater than zero.");

		}

	}

	public final boolean isAlignmentORWidthNull() {
		return alignment == null || width == null;
	}

	public final boolean isAlignmentORWidthNegetive() {
		return alignment < 0 || width < 0;
	}

	public final boolean isAlignmentOutofRange() {
		return alignment < 1 || alignment > 6;
	}

	public Boolean textFormatting() {
		Boolean isFormatet=false;
		switch (alignment) {
		case 1:
			isFormatet=leftAlignmentText();
			break;
		case 2:
			isFormatet=rightAlignmentText();
			break;
		case 3:
			isFormatet=centerAlignmentText();
			break;
		case 4:
			isFormatet=rightJustifyText();
			break;
		case 5:
			isFormatet=wrapText();
			break;
		case 6:
			System.out.println(" under construction .. ");
			break;

		default:
			System.out.println("Format Type is not correct!");
			break;
		}
		return isFormatet;
	}

	private Boolean leftAlignmentText() {
		String formattedText = "";

		System.out.println("left alignment");

		formattedText = String.format("%1$-" + width + "s", text);
		System.out.println(formattedText);
		return true;
	}

	private Boolean rightAlignmentText() {
		String formattedText = "";

		System.out.println("right alignment");
		formattedText = String.format("%1$" + width + "s", text);
		System.out.println(formattedText);
		return true;
	}

	private Boolean centerAlignmentText() {
		String formattedText = "";

		System.out.println("center ");
		formattedText = String.format("%1$" + (width / 2) + "s", text);
		System.out.println(formattedText);
		return true;
	}

	private Boolean rightJustifyText() {
		String formattedText = "";

		System.out.println("justify with right alignment");
		String test = "";

		int i = 0;
		while (i + LENGHT_OF_WRAP < text.length()) {
			test = text.substring(i, i + LENGHT_OF_WRAP);
			formattedText = String.format("%1$-10s %2$" + width + "s", "", test);
			System.out.println(formattedText);
			i = i + LENGHT_OF_WRAP;
		}
		;
		if (i - LENGHT_OF_WRAP < text.length()) {
			test = text.substring(i, text.length());
			formattedText = String.format("%1$-10s %2$" + width + "s", "", test);
			System.out.println(formattedText);

		}

//		while (i + LENGHT_OF_WRAP < text.length()) {
//			test = test + text.substring(i, i + LENGHT_OF_WRAP) + "\n";
//			i = i + LENGHT_OF_WRAP;
//		}
//		;
//		if (i - LENGHT_OF_WRAP < text.length()) {
//			test = test +text.substring(i, text.length())+"\n";
//			
//		}
//		System.out.println(" test " + test );
//		formattedText = String.format("%1$-10s %2$" + width + "s", "", test);
//		System.out.println(formattedText);
//		
		return true;
	}

	private Boolean wrapText() {
		System.out.println(" in 5 - wrap ");
		String test = "";

		int i = 0;
		while (i + LENGHT_OF_WRAP < text.length()) {
			test = test + text.substring(i, i + LENGHT_OF_WRAP) + "\n";
			i = i + LENGHT_OF_WRAP;
		}
		if (i - LENGHT_OF_WRAP < text.length()) {
			test = test + text.substring(i, text.length()) + "\n";
		}
		;
		System.out.println(test);
		return true;
	}
}
