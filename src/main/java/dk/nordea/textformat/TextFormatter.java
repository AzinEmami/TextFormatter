package dk.nordea.textformat;

/**
 * This class is responsible to format text.
 * <p>
 * There is five kind of formatting.
 * {@link dk.nordea.textformat.TextFormatter.AligmentEnum}
 *
 * <p>
 * Before formatting a text 3 conditions should be satisfied:
 * <p>
 * 1)Alignment and width should not be null.
 * <p>
 * 2)Alignment should be between 1 to 5.
 * <p>
 * 3)Width should not be negative.
 *
 * @author Azin
 */

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
			throw new IndexOutOfBoundsException("  each must be greater than zero.");

		}

		if (isWidthNegetive()) {
			throw new IllegalArgumentException("  each must be greater than zero.");

		}

	}

	public final boolean isAlignmentORWidthNull() {
		return alignment == null || width == null;
	}

	public final boolean isWidthNegetive() {
		return width < 0;
	}

	public final boolean isAlignmentOutofRange() {
		return alignment < 1 || alignment > 6;
	}

	/**
	 * select the operation based on user request and running it. 
	 * @return true if text formats successfully, false in formats fails.
	 */
	public Boolean textFormatting() {
		Boolean isFormatet = false;
		switch (alignment) {
		case 1:
			isFormatet = leftAlignmentText();
			break;
		case 2:
			isFormatet = rightAlignmentText();
			break;
		case 3:
			isFormatet = centerAlignmentText();
			break;
		case 4:
			isFormatet = rightJustifyText();
			break;
		case 5:
			isFormatet = wrapText();
			break;
		case 6:
			System.out.println(" under construction .. ");
			isFormatet = true;
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

	/**
	 * methodes breaks the text to several lines and formats each of them.
	 * @return true after formatting text
	 */
	private Boolean rightJustifyText() {
		String formattedText = "";

		System.out.println("justify with right alignment");
		String wrapedLine = "";

		int i = 0;
		while (i + LENGHT_OF_WRAP < text.length()) {
			wrapedLine = text.substring(i, i + LENGHT_OF_WRAP);
			formattedText = String.format("%1$-10s %2$" + width + "s", "", wrapedLine);
			System.out.println(formattedText);
			i = i + LENGHT_OF_WRAP;
		}
		;
		if (i - LENGHT_OF_WRAP < text.length()) {
			wrapedLine = text.substring(i, text.length());
			formattedText = String.format("%1$-10s %2$" + width + "s", "", wrapedLine);
			System.out.println(formattedText);

		}
		return true;
	}

	private Boolean wrapText() {
		System.out.println(" in 5 - wrap ");
		String wrapedText = "";

		int i = 0;
		while (i + LENGHT_OF_WRAP < text.length()) {
			wrapedText = wrapedText + text.substring(i, i + LENGHT_OF_WRAP) + "\n";
			i = i + LENGHT_OF_WRAP;
		}
		if (i - LENGHT_OF_WRAP < text.length()) {
			wrapedText = wrapedText + text.substring(i, text.length()) + "\n";
		}
		;
		System.out.println(wrapedText);
		return true;
	}
}
