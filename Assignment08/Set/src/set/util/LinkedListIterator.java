package set.util;
/**
 * This class creates an iterator for a LinkedList
 * @Author Adam Cichoski, Bennet Scott, Caleb Free, Logan Keiper
 * @param T is a generic type of element that is being stored in each node
 */
public class LinkedListIterator<T> {
    ListNode<T> current;
    /**
     * Constructor to set the value for the current node
     * @param node
     */
    LinkedListIterator(ListNode<T> node){
        current = node;
    }
    /**
     * Checks to see if the current node element is null or not
     * @return true or false if the current node is null
     */
    public boolean isValid(){
        return current!=null;
    }
    /**
     * Gets the element in the current node if the node is valid
     * @return the element in the current node
     */
    public T retrieve(){
        return isValid() ? current.element: null;
    }
    /**
     * This method checks if the current node is valid, and if 
     * so then it sets the current node to the next node address
     * that is being stored in the current node instance
     */
    public void advance(){
        current = (isValid())? current.next: current;
    }
}
