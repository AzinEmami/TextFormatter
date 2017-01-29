package dk.nordea.test;


/**
 * This is a parameterized class which is in charge of testing the formatting text.
 *
 * @author Azin
 */

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import dk.nordea.textformat.TextFormatter;
import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class TextFormatterTest {

	
	private final Integer alignment, width;
	private final String text;

	
	public TextFormatterTest(Integer alignment, Integer width, String text
			) {
		this.alignment = alignment;
		this.width = width;
		this.text = text;
			}
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            { 1, 10 , " test text "},
            { 2, 10 , " test text "},
            { 3, 10 , " test text "},
            { 4, 10 , " test text "},
            { 5, 10 , " test text "},
            });
    }
	
	@Test
	public void textFormattingText() {
		TextFormatter textFormatter = new TextFormatter(alignment, width,text);
	    Assert.assertTrue( " the text is not formatted properly! " , textFormatter.textFormatting());
	}
}
