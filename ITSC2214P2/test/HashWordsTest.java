import org.junit.*;
import static org.junit.Assert.*;

/**
 * testing cases for hash words
 */
public class HashWordsTest {
    // Object to be tested
    private HashWords runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashWords(10);
    }

    /**
     * Test hashKey() method
     */
    @Test
    public void testHashKey() {
        assertEquals("Incorrect hashKey for 'hello'", 2, runner.hashKey("hello"));
        assertEquals("Incorrect hashKey for 'bye'", 0, runner.hashKey("bye"));
        assertEquals("Incorrect hashKey for 'world'", 3, runner.hashKey("world")); // Assuming some example
    }

    /**
     * Test addWord() and totalNumOfWords() methods
     */
    @Test
    public void testAddWordAndTotalWords() {
        runner.addWord("hello");
        assertEquals("Total number of words should be 1", 1, runner.totalNumOfWords());

        runner.addWord("hello");
        assertEquals("Total number of words should be 2 after adding 'hello' again", 2, runner.totalNumOfWords());
    }

    /**
     * Test numUniqueWordsInTable() method
     */
    @Test
    public void testNumUniqueWords() {
        runner.addWord("hello");
        runnerunner.addWord("hello");
        assertEquals("Unique words count should be 1", 1, runner.numUniqueWordsInTable());

        runner.addWord("world");
        assertEquals("Unique words count should be 2", 2, runner.numUniqueWordsInTable());
    }

    /**
     * Test frequency() method
     */
    @Test
    public void testFrequency() {
        runner.addWord("hello");
        runner.addWord("hello");
        assertEquals("Frequency of 'hello' should be 2", 2, runner.frequency("hello"));

        runner.addWord("world");
        assertEquals("Frequency of 'world' should be 1", 1, runner.frequency("world"));
    }

    /**
     * Test termFrequency() method
     */
    @Test
    public void testTermFrequency() {
        runner.addWord("hello");
        runner.addWord("hello");
        runner.addWord("world");
        assertEquals("Term frequency of 'hello' should be 2/3", 2.0/3.0, runner.termFrequency("hello"), 0.001);
        assertEquals("Term frequency of 'world' should be 1/3", 1.0/3.0, runner.termFrequency("world"), 0.001);
    }

    /**
     * Test contains() method
     */
    @Test
    public void testContains() {
        runner.addWord("hello");
        assertTrue("Table should contain 'hello'", runner.contains("hello"));
        assertFalse("Table should not contain 'bye'", runner.contains("bye"));
    }

    /**
     * Test mostCommonWord() method
     */
    @Test
    public void testMostCommonWord() {
        runner.addWord("hello");
        runner.addWord("hello");
        runner.addWord("world");
        assertEquals("Most common word should be 'hello'", "hello", runner.mostCommonWord());

        runner.addWord("bye");
        runner.addWord("bye");
        runner.addWord("bye");
        assertEquals("Most common word should be 'bye'", "bye", runner.mostCommonWord());
    }

    /**
     * Test table expansion when storage is exhausted
     */
    @Test
    public void testTableExpansion() {
        runner = new HashWords(3); // Small table to force expansion
        runner.addWord("hello");
        runner.addWord("hello");
        runner.addWord("world");
        runner.addWord("bye");
        assertEquals("Total words should be 4 after adding words", 4, runner.totalNumOfWords());
        assertEquals("Unique words count should be 3", 3, runner.numUniqueWordsInTable());
    }

    /**  
     * Test size() method  
    */ 
    @Test  
    public void testSize() {  
        assertEquals("Incorrect size", 10, runner.size());
    }
}
