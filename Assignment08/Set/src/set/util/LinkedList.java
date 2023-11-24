package set.util;

import java.util.Iterator;

/**
 * This is the class for a LinkedList
 * @Author Adam Cichoski, Bennet Scott, Caleb Free, Logan Keiper
 * @param T is a generic type to be stored in the LinkedList
 */
public class LinkedList<T> implements Iterable<T>{
    private ListNode<T> header;

    /**
     * Constructing the LinkedList to have a null header
     */
    public LinkedList(){
        header = new ListNode<T>(null);
    }
    /**
     * Checks if the LinkedList is empty
     * @return true or false if empty 
     */
    public boolean isEmpty(){
        return header.next ==null;
    }
    /**
     * Empties out the LinkedList
     */
    public void makeEmpty(){
        header.next=null;
    }
    /**
     * Creates a new LinkedListIterator and initializes its "current" node 
     * to this LinkedLists "header" node
     * @return a new LinkedListIterator
     */
    public LinkedListIterator<T> zeroth(){
        return new LinkedListIterator<T>(header);
    }
    /**
     * Creates a new LinkedListIterator and initializes its "current" node to 
     * the node after this LinkedLists header node
     * @return new LinkedListIterator
     */
    public LinkedListIterator<T> first(){
        return new LinkedListIterator<T>(header.next);
    }
    /**
     * Inserts a new element in the LinkedList after the inputted
     * index (iterator p) only if index p is not null, and as long as
     * p is valid
     * @param x is the element to be inserted
     * @param p is the index of the elment that x will be inserted after
     */
    public void insert(T x, LinkedListIterator<T> p ){
        if (p !=null && p.isValid()){
            p.current.next = new ListNode<T>(x,p.current.next);
        }
    }
    /**
     * This method finds an element in the LinkedList using a
     * LinkedListIterator. O(n) runtime. 
     * @param x is the element that is being searched for 
     * @return the index of the element
     */
    public LinkedListIterator<T> find(T x){
        ListNode<T> ref = header.next;
        while(ref != null && !ref.element.equals(x)){
            ref = ref.next;
        }
        return new LinkedListIterator<T>(ref);
    }
    /**
     * Runs a loop until the next element is equal to the element that
     * is being searched for, and returns the current index
     * @param x is the element that is being searched for 
     * @return the element before the searched element
     */
    public LinkedListIterator<T> findPrevious(T x){
        ListNode<T> ref = header;
        while(ref.next!=null && !ref.next.element.equals(x)){
            ref = ref.next;
        }
        return new LinkedListIterator<T>(ref);
    }
    /**
     * Prints out the values held in the LinkedList as long as the list is not empty
     * @param <AnyType> is a generic to hold any type 
     * @param list is the LinkedList
     */
    public static <AnyType> void printList(LinkedList<AnyType> list){
        if(list.isEmpty()){
            System.out.print("Empty List");
        } else{ 
            LinkedListIterator<AnyType> iterator = list.first();
            for(; iterator.isValid();iterator.advance()){
                System.out.print(iterator.retrieve()+" ");
            }
        }
        System.out.println();
    }
    /**
     * Returns the size of the array
     * @param <AnyType> is a generic for any type
     * @param list is the LinkedList
     * @return size
     */
    public static <AnyType> int listSize(LinkedList<AnyType> list){
        LinkedListIterator<AnyType> iterator;
        int size=0;
        for(iterator = list.first(); iterator.isValid(); iterator.advance()){
            size++;
        }
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        LinkedListIterator<T> marker = this.zeroth();
        return marker;
    }

}
