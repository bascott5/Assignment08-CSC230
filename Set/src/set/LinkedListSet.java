package set;

/**
 * This class represents the combination between both a Linked List and a Set.
 * @Author Adam Cichoski, Bennett Scott, Caleb Free, Logan Keiper
 * @param <T> 
 */
public class LinkedListSet<T extends Comparable<? super T>> extends LinkedList<T> {
    private int cardinality = 0;
    private LinkedList<T> setList;

    /**
     * This constructor sets the cardinality and initializes the LinkedList.
     */
    public LinkedListSet() {
        this.cardinality = 0;
        this.setList = new LinkedList<T>();
    }

    /**
     * Combines two sets.
     * 
     * @param list that will be combined with this
     * @return Set whose values are combined from this and set
     */
    public LinkedListSet<T> unionLinkedList(LinkedListSet<T> set) {
        LinkedListSet<T> unionSet = new LinkedListSet<T>();

        LinkedListIterator<T> marker1;
        LinkedListIterator<T> marker2;
        LinkedListIterator<T> marker3;
        marker1 = this.first();
        marker2 = set.first();
        marker3 = unionSet.zeroth();

        while (marker1.isValid() && marker2.isValid()) {
            if (marker1.current.element.compareTo(marker2.current.element) < 0) {
                unionSet.insert(marker1.current.element, marker3);
                marker1.advance();
            } else if (marker1.current.element.compareTo(marker2.current.element) == 0) {
                unionSet.insert(marker1.current.element, marker3);
                marker1.advance();
                marker2.advance();
            } else {
                unionSet.insert(marker2.current.element, marker3);
                marker2.advance();
            }
        }

        for (; marker1.isValid(); marker1.advance()) {
            unionSet.insert(marker1.current.next.element, marker3);
        }
        for (; marker2.isValid(); marker2.advance()) {
            unionSet.insert(marker2.current.element, marker3);
        }

        return unionSet;
    }

    @Override
    /**
     * Inserts an element into a set.
     * 
     * @throws SetException if set is full
     */
    public void insert(T newElement, LinkedListIterator<T> p) {
            if (!contains(newElement) && p.isValid()) {
            setList.insert(newElement, p);
            cardinality++;
        }
    }

    /**
     * Checks if a set already contains a certain value.
     * 
     * @param testElement element to be compared against the rest of the set
     * @return true or false if the element is already within the set.
     */
    public boolean contains(T testElement) {
        LinkedListIterator<T> tester = this.find(testElement);
        return tester.isValid();
    }


    /**
     * Gets a sets Cardinality.
     * 
     * @return cardinality this
     */
    public int getCardinality() {
        return cardinality;
    }
    /**
     * Creates a new list consisting of the intersecting values of different sets.
     * 
     * @param set is the set to be compared to this set
     * @return intersection set
     */
    public LinkedListSet<T> intersection(LinkedListSet<T> set){
        LinkedListSet<T> intersectSet = new LinkedListSet<>();
        LinkedListIterator<T> marker = setList.zeroth(), newSet = intersectSet.zeroth();
        for(;marker.isValid();marker.advance()){
            if(set.contains((T) marker.retrieve())){
                intersectSet.insert((T) marker.retrieve(), newSet);
                newSet.advance();
            }
        }
        return set;

    }

    /**
     * This prints out the set.
     */
    public void print(){
        LinkedList.printList(setList);
    }

}