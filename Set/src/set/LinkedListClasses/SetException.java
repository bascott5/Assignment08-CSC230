package set.LinkedListClasses;

/**
 * This class contains methods for setting exceptions for the Generic Set.
 * @Author Adam Cichoski, Bennett Scott, Caleb Free, Logan Keiper
 */
public class SetException extends RuntimeException {

    /**
     * This method sets an exception.
     */
    public SetException() {
        super();
    }

    /**
     * This method sets an exception while taking string as an input.
     * 
     * @param s 
     */
    public SetException(String s) {
        super(s);
    }
}
