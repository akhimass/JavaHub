package datastructures;
import itsc2214.Node;
import itsc2214.QueueADT;

/**
 * Linked list implementation of Queues. 
 * 
 * @author ITSC 2214
 *
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /* front: the beginning of the queue */
    private Node<T> front;
    
    /* rear: the end of the queue */
    private Node<T> rear;
    
    /* size: the number of elements in the queue */
    private int size;
    
    /**
     * Constructor.
     */
    public LinkedQueue() {
        // Instantiate the linked list-based data collection
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Insert an element in the end of the queue.
     * @param target input element
     */
    @Override
    public boolean enqueue(T target) {
        // If queue is empty, insert new node and change the rear and front references
        Node<T> newNode = new Node<>(target, null);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
        
        return true;
    }
    
    /**
     * Remove from the beginning of the queue.
     * @return the removed element
     */
    @Override
    public T dequeue() {
        // If queue is empty, throw an exception.
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T data = front.getData();
        front = front.getNext();
        size--;
        
        if (isEmpty()) {
            rear = null;
        }
        
        return data;
    }
    
    /**
     * Examine whether the queue is empty.
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //Evaluate whether the queue is empty
        return size == 0;
    }
    
    /**
     * Retrieve the front.
     * @return the element in the beginning of the queue 
     */
    @Override
    public T frontValue() {
        // Return element in the frontmost position of the array
        return isEmpty() ? null : front.getData();
    }
    
    /**
     * Retrieve the size.
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //Return the size of the QueueADT
        return size;
    }

    /**
     * Clear the queue.
     */
    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.dequeue();
        }
    }
}