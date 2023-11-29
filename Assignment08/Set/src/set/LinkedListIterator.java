package set;
import java.util.Iterator;

/**
 * This class creates an iterator for a LinkedList.
 * @Author Adam Cichoski, Bennet Scott, Caleb Free, Logan Keiper
 * @param T is a generic type of element that is being stored in each node
 */
public class LinkedListIterator<T> implements Iterator<T>{
    protected ListNode<T> current;
    /**
     * Constructor to set the value for the current node.
     * 
     * @param node
     */
    LinkedListIterator(ListNode<T> node){
        current = node;
    }
    /**
     * Checks to see if the current node element is null or not.
     * 
     * @return true or false if the current node is null
     */
    public boolean isValid(){
        return current!=null;
    }
    /**
     * Gets the element in the current node if the node is valid.
     * 
     * @return the element in the current node
     */
    public T retrieve(){
        return isValid() ? current.element: null;
    }
    /**
     * This method checks if the current node is valid, and if 
     * so then it sets the current node to the next node address
     * that is being stored in the current node instance.
     */
    public void advance(){
        current = (isValid())? current.next: current;
    }
    /**
     * This method checks if the next node exists.
     * 
     * @return true or false if the next node is null
     */
    @Override
    public boolean hasNext() {
        if (current.next != null){
            return true;
        }
        return false;
    }
    /**
     * This method advances the current node.
     * 
     * @return the next node as the new current one
     */
    @Override
    public T next() {
        T temp = current.next.element;
        this.advance();
        return temp;
    }
}

