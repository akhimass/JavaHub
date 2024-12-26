package datastructures;
import itsc2214.Node;
import itsc2214.StackADT;

/**
 * Linked list implementation of Stacks. 
 * 
 * @author ITSC 2214
 * @version 1.0
 * @param <T> 
 */
public class LinkedStack<T> implements StackADT<T> {
    /* top: the top of the stack */
    private Node<T> top;

    /* size: the number of elements in the stack */
    private int size;

    /**
     * Constructor.
     */
    public LinkedStack() {
        // Instantiate the linked list-based data collection
        top = null;
        size = 0;
    }

    /**
     * Insert an element on the top of the stack.
     * @param target input element
     */
    @Override
    public boolean push(T target) {
        // Create a new node to hold the target element
        Node<T> newNode = new Node<>(target, top);
        top = newNode; // Set the new node as the top
        size++; // Increment the size
        return true;
    }

    /**
     * Remove out of the top of the stack.
     * @return the removed element
     */
    @Override
    public T pop() {
        // If the stack is empty, throw an exception
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        T data = top.getData();
        top = top.getNext();
        size--; 
        
        return data; 
        
    }

    /**
     * Retrieve the element on the top of the stack.
     * @return the element on the top of the stack
     */
    @Override
    public T topValue() {
        // Return the top item without modifying the stack
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }

    /**
    * Examine whether the stack is empty.
    * @return true: if the stack is empty
    *         false: if the stack is not empty
    */
    @Override
    public boolean isEmpty() {
        //Evaluate whether the stack is empty
        return size == 0;
    }

    /**
    * Retrieve the size.
    * @return number of elements in the queue
    */
    @Override
    public int size() {
        //Return the size of the stack 
        return size;
    }

    /**
     * Clear the stack.
     */
    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.pop();
        }
    }
    /*
     * main() function.
     * @param argv no arguments */
    public static void main(String argv[]){
        final  int iSIZE = 10;
        LinkedStack<String> stringStack = new LinkedStack<String>();
        
        String line;
        for (int i = 0; i < iSIZE; i++) {
            //push the new element
            stringStack.push(Integer.valueOf(i).toString());
        }
        try{            
            System.out.println("\nOpposite order is: ");
            for (int i = 0; i < iSIZE; i++){
                line = stringStack.pop();
                
                System.out.println(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}