import org.junit.*;
import static org.junit.Assert.*;

/**
 * testing cases for word frequency methods
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * Test that right word is stored
     */
    @Test
    public void testGetWord() {
        assertEquals("Word stored is wrong", "Hello", runner.getWord());
    }

    /**
     * Test that initial count is correct
     */
    @Test
    public void testGetCountInitial() {
        assertEquals("Initial count should be 1", 1, runner.getCount());
    }

    /**
     * Test the increment method increases count correctly
     */
    @Test
    public void testIncrement() {
        runner.increment();
        assertEquals("Count after increment is wrong", 2, runner.getCount());
    }

    /**
     * Test equality with case for WordFrequency objects
     */
    @Test
    public void testEqualsWithWordFrequency() {
        WordFrequency anotherRunner = new WordFrequency("hello");
        assertTrue("Words should be equal ignoring case", runner.equals(anotherRunner));
    }

    /**
     * Test equality with case for a String
     */
    @Test
    public void testEqualsWithString() {
        assertTrue("Words should be equal ignoring case", runner.equals("hello"));
    }

    /**
     * Test inequality with a different word
     */
    @Test
    public void testNotEqualsWithDifferentWord() {
        assertFalse("Words should not be equal", runner.equals("goodbye"));
    }

    /**
     * Test equals method with null value
     */
    @Test
    public void testNotEqualsWithNull() {
        assertFalse("Null should not be equal to word", runner.equals(null));
    }

}
