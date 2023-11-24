package set.util;

import set.SetException;

public class GenericComparableSet<T extends Comparable<? super T>> extends LinkedList<T>{
    private int cardinality = 0;
    private final int MAXSIZE;
    private LinkedList<T> setList;

    public GenericComparableSet(int maxSize){
        this.MAXSIZE = maxSize;
        this.cardinality = 0;
        this.setList = new LinkedList<T>();
    }

    /**
     * Combines two sets
     * @param list that will be combined with this
     * @return Set whose values are combined from this and set
     */
    public GenericComparableSet<T> unionLinkedList(GenericComparableSet<T> set){
         GenericComparableSet<T> unionSet = new GenericComparableSet<T>(this.MAXSIZE + set.MAXSIZE);
        
         LinkedListIterator<T> marker1;
         LinkedListIterator<T> marker2;
         LinkedListIterator<T> marker3;
         marker1 = this.first();
         marker2 = set.first();
         marker3 = unionSet.zeroth();

        while(marker1.isValid() && marker2.isValid()){
            if (marker1.current.element.compareTo(marker2.current.element) < 0){
                unionSet.insert(marker1.current.element, marker3);
                marker1.advance();
            }else if(marker1.current.element.compareTo(marker2.current.element) == 0){
                unionSet.insert(marker1.current.element, marker3);
                marker1.advance();
                marker2.advance();
            }else {
                unionSet.insert(marker2.current.element, marker3);
                marker2.advance();
            }
        }

        for(; marker1.isValid(); marker1.advance()){
            unionSet.insert(marker1.current.next.element, marker3);
        }
        for(; marker2.isValid(); marker2.advance()){
            unionSet.insert(marker2.current.element, marker3);
        }
        
        return unionSet;
    }
    
    @Override
    /**
     * Inserts an element into a set
     * @throws SetException if set is full
     */
    public void insert(T newElement, LinkedListIterator<T> p){
        if(cardinality >= MAXSIZE){
            throw new SetException("Set is full!");
        }else if(!contains(newElement) && p.isValid()){
            p.current.next = new ListNode<T>(newElement,p.current.next);
            cardinality++;
            p.advance();
        }
    }

    /**
     * Checks if a set already contains a certain value
     * @param testElement element to be compared against the rest of the set
     * @return true or false if the element is already within the set.
     */
    public boolean contains(T testElement){
        LinkedListIterator<T> marker = this.first();

        for(; marker.isValid(); marker.advance()){
            if(marker.current.element.equals(testElement)){
                return true;
            }
        }
        return false;
    }


}
