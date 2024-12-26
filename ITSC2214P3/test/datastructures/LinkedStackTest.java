package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;

/**
 * ITSC 2214 Melody.
 * Instructor-provided code.
 */
public class LinkedStackTest {
    LinkedStack<Integer> stack;

    /**
     * Initialize the LinkedStack instance.
     */
    @Before
    public void setup() {
        stack = new LinkedStack<Integer>();
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(6);
        assertFalse(stack.isEmpty());
        assertEquals(6, stack.topValue().intValue());
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testTopValue1() throws Exception {
        //test topValue() on an empty stack
        assertNull(stack.topValue());
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testTopValue2() {
        stack.push(10);
        assertEquals(10, stack.topValue().intValue()); //returns 10
        stack.push(20);
        assertEquals(20, stack.topValue().intValue());//now returns 20
        assertEquals(2, stack.size());//stack size should not change
    }
    
    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop1() {
        try{
            stack.pop();
            fail("Expected an exception when popping from an empty stack");
        } catch (NoSuchElementException e){
            //passes if exception is thrown
        }

    }
    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop2() {
        stack.push(30);
        stack.push(40);
        assertEquals(40, stack.pop().intValue());
        assertEquals(1, stack.size());
        assertEquals(30, stack.topValue().intValue());
    }
    
    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        //TODO test your push method of LinkedQueue<Integer>
        stack.push(4);
        assertEquals(1, stack.size());
        assertEquals(4, stack.topValue().intValue());
        stack.push(6);
        assertEquals(2, stack.size());
        assertEquals(6, stack.topValue().intValue());
        stack.pop();
        assertEquals(4, stack.topValue().intValue());
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        stack.push(4);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }
    
    /**
     * Test of clear() method of class LinkedStack.
     */
    @Test
    public void testClear() {
        stack.push(4);
        stack.push(6);
        stack.clear();
        assertEquals(0, stack.size());
        assertNull(stack.topValue());
    }
}