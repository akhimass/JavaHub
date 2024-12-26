import org.junit.*;
import static org.junit.Assert.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.function.*;
import java.util.Arrays;


public class Project1Test 
{
    private CollectionUtilities<Integer> intRunner;
    private CollectionUtilities<String> stringRunner;

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     * 
     * For example, if you want to test it with Strings,
     * create an instance like this:
     * 
     *  private CollectionUtilities<String> runner;
     */

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup()
    {
        ArrayList<Integer> intList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        intRunner = new Project1<>(intList1);
;        // create some data for testing, then
        // initialize your runner object.

        ArrayList<String> stringList1 = new ArrayList<>(Arrays.asList("aaa", "bbbbb", "cccc"));
        stringRunner = new Project1<>(stringList1);
    }

    /**
     * testingCases() 
     */
    @Test
    public void testingCases()
    {
        //findSmallest test case
        assertEquals(Integer.valueOf(1), intRunner.findSmallest());
        assertEquals("aaa", stringRunner.findSmallest());

        //findLargest test case
        assertEquals(Integer.valueOf(5), intRunner.findLargest());
        assertEquals("cccc", stringRunner.findLargest());

        /*hasDuplicates test case
        integer test case*/
        assertFalse(intRunner.hasDuplicates());

        ArrayList<Integer> duplicateIntList = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        CollectionUtilities<Integer> duplicateIntRunner = new Project1<>(duplicateIntList);
        assertTrue(duplicateIntRunner.hasDuplicates());

        //string test case
        ArrayList<String> duplicateStringList = new ArrayList<>(Arrays.asList("aaa", "bbbbb", "aaa"));
        CollectionUtilities<String> duplicateStringRunner = new Project1<>(duplicateStringList);
        assertTrue(duplicateStringRunner.hasDuplicates());

        /*findOneThat test case
        integer test*/
        assertEquals(Integer.valueOf(5), intRunner.findOneThat(p -> p > 3));//using lambda operation from online coding source, easier than for loop
        //string test
        assertEquals("bbbbb", stringRunner.findOneThat(s -> s.length() > 4));//using lambda operation from online coding source

        /*filteredList test case
        integer test*/
        ArrayList<Integer> filteredIntList = new ArrayList<>(Arrays.asList(5,4));
        assertEquals(filteredIntList, intRunner.filterList(p -> p > 3));
        //string test
        ArrayList<String> filteredStringList = new ArrayList<>(Arrays.asList("aaa"));
        assertEquals(filteredStringList, stringRunner.filterList(s -> s.charAt(0) == 'a'));

    }
}
