package set.LinkedListClasses;

/**
 * This class is used to create nodes for a linked list.
 * @Author Adam Cichoski, Bennett Scott, Caleb Free, Logan Keiper
 * @param T is a generic type to be the element stored in the Node
 */
public class ListNode<T> {
    public T element;
    public ListNode<T> next;

    /**
     * This constructor only takes in the generic element to pass
     * over to the other constructor.
     * 
     * @param element is the element stored in the node
     */
    public ListNode(T element){
        this(element, null);
    }
    /**
     * This constructor takes in the element to be stored in the node 
     * and address to the next node.
     * 
     * @param element is the stored element
     * @param next the address of the next node
     */
    public ListNode(T element, ListNode<T> next){
        this.element = element;
        this.next = next;
    }
}
