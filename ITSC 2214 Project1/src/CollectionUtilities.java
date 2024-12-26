import java.util.AbstractList;
import java.util.function.Predicate;

import org.pitest.reloc.antlr.common.collections.List;

public interface CollectionUtilities<T extends Comparable<T>> {

    /**
     * findSmallest returns the smallest item in the internal
     * collection by doing an iteration over the collection
     * and finding the smallest value stored in the collection.
     * Smallest is determined by calling compareTo() on the
     * elements of the collection.
     * @return smallest element in the collection
     */
    T findSmallest();

    /**
     * findLargest returns the largest item in the internal
     * collection by doing an iteration over the collection
     * and finding the largest value stored in the collection.
     * Largest is determined by calling compareTo() on the
     * elements of the collection.
     * @return largest element in the collection
     */
    T findLargest();

    /**
     * hasDuplicates returns true if an element appears twice in the
     * collection. Best way to do this is with a nested loop checking
     * each element to every other element in the collection. Make sure
     * you don't check an element to itself. Use compareTo() to check
     * if any two values are identical.
     * @return true if the collection has at least one duplicate, false otherwise
     */
    boolean hasDuplicates();

    /**
     * findOneThat iterates through to find elements
     * by nested loop and returns element
     * @return element
     */
    T findOneThat(Predicate<T> p);

    /**
     * Abstract list filters list iterates through to find elements
     * by nested loop and returns list of elements
     * @return abstract list of element
     */
    AbstractList<T> filterList(Predicate<T> p);



}