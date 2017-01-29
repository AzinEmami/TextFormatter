package dk.nordea.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

import dk.nordea.textformat.UserInput;

/**
 * This class is responsible to check getting input of user. it will check if
 * scanner ignores non integer values properly.
 *
 * @author Azin
 */
public class UserInputTest {

    /**
     * Check if ({@link dk.nordea.textformat.UserInput#getFormatInputs()}) will
     * return first two numbers of user input and will handle
     * InputMismatchException in case user enter any non integer value.
     */
    @Test
    public void shouldGetUserInput() {
        UserInput userInput = new UserInput();
        String mockInput = "a b 2  n 3 c ";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);
        List<Integer> results = userInput.getFormatInputs();
        Assert.assertThat("it should get 2 integers !!", results.size(), is(2));
        Assert.assertThat(results.get(0), is(2));
        Assert.assertThat(results.get(1), is(3));

    }

}
