import java.util.AbstractList;
import java.util.function.*;
import java.util.ArrayList;

/**
 * Project1 - class that take a collection (AbstractList) as
 * argument and provides various operations on the content of that
 * collection.
 * 
 * @author Akhi Chappidi
 * @version 09/16/2024
 */
/**
 * This class performs operations on collection like finding 
 * @param <T> type of elements in collection, implement comparable interface
 */

/* Class to perform operations of finding largest, smallest elements
 detecting duplicate elements and filtering */
public class Project1<T extends Comparable<T>> implements CollectionUtilities<T> {
    /** 
     * a list of type T storing elements
    */
    private AbstractList<T> list;

    /** constructor for the Project1 class 
    * @param list of type T class performs operations on
    */
    public Project1(AbstractList<T> list){
        this.list = list;
    }
    /** method to find smallest element in collection
    * @return smallest element
    */
    @Override
    public T findSmallest(){
        if(list.isEmpty()){
            throw new IllegalStateException("Can't find smallest element in empty collection");
        }

        T smallest = list.get(0);
        for (T element: list){
            if (element. compareTo(smallest) < 0){
                smallest = element;
            }
        }
        return smallest;

    }
    /** method to find largest element in collection
    * @return largest element
    */
    @Override
    public T findLargest(){
        if(list.isEmpty()){
            throw new IllegalStateException("Can't find largest element in empty collection");
        };

        T largest = list.get(0);
        for (T element: list){
            if (element. compareTo(largest) > 0){
                largest = element;
            }
        }
        return largest;

    }
    /** method to find duplicate elements
    * @return true or false if element is duplicate
    */
    @Override
    public boolean hasDuplicates(){
        for (int i = 0; i < list.size(); i++){
            T element1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++){
                T element2 = list.get(j);
                if (element1.compareTo(element2) == 0){
                    return true;
                }
            }
        }
        return false;

    }

    /** method to find elements 
    *that match the predicate
    * @param p predicate used to test elements
    * @return elements that match predicate for filter
    */
    public T findOneThat(Predicate<T> p){
        for (T element: list){
            if(p.test(element)){
                return element;
            }
        }
        return null;
    }

    /** method to filter elements 
    *based on the predicate
    * @param p predicate used to test elements
    * @return filteredList of elements matching predicate
    */
    public AbstractList<T> filterList(Predicate<T> p){
        ArrayList<T> filteredList = new ArrayList<>();
        for (T element: list){
            if(p.test(element)){
                filteredList.add(element);
            }
        }
        return filteredList;
    }
}
