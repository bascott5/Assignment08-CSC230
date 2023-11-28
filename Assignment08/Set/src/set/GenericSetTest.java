package set;
import set.util.*;

public class GenericSetTest {
    public static void main(String[] args) {
        System.out.println("Testing insert method...");
        LinkedListSet<Integer> s1 = new LinkedListSet<>();
        LinkedListIterator<Integer> s3marker = s1.zeroth();
        s1.insert(4, s3marker);
        s1.insert(2, s3marker);
        s1.insert(1, s3marker);
        s1.insert(5, s3marker);
        s1.insert(6, s3marker);
        
        System.out.print("All elements in s1: ");
        LinkedListSet.printList(s1); // output: 6 5 1 2 4
        
        LinkedListSet<Integer> s2 = new LinkedListSet<>();
        LinkedListIterator<Integer> s4marker = s2.zeroth();
        s2.insert(5, s4marker);
        s2.insert(8, s4marker);
        s2.insert(9, s4marker);
        s2.insert(1, s4marker);
        
        System.out.print("All elements in s2: ");
        LinkedListSet.printList(s2); // output: 1 9 8 5
        
        System.out.print("\nTesting unionLinkedList method...");
        LinkedListSet<Integer> s5 = s1.unionLinkedList(s2);
        
        System.out.print("\nUnion of s1 and s2: ");
        for(Integer value : s5){
            System.out.print(value + " "); // output: 4 2 1 5 6 8 9
        }

        System.out.println("\n\nTesting contains method...");
        System.out.println("Does s1 contain 3?: " + s1.contains(3)); // output: false
        System.out.println("Does s1 contain 4?: " + s1.contains(4)); // output: true
        
        System.out.println("\nTesting getCardinality method...");
        System.out.println("Cardinality of s1: " + s1.getCardinality()); // output: 5
        System.out.println("Cardinality of s2: " + s2.getCardinality()); // output: 4
        
        System.out.println("\nTesting zeroth method...");
        System.out.println("Zeroth element of s1: " + s1.zeroth().retrieve()); // output: null
        System.out.println("Zeroth element of s2: " + s2.zeroth().retrieve()); // output: null
        
        System.out.println("\nTesting first method...");
        System.out.println("First element of s1: " + s1.first().retrieve()); // output: 4
        System.out.println("First element of s2: " + s2.first().retrieve()); // output: 5
        
        System.out.println("\nTesting find and findPrevious methods...");
        System.out.println("The middle element of s1 is: " + s1.find(1).retrieve()); // output: 1
        System.out.println("The method right behind 1 is: " + s1.findPrevious(1).retrieve()); // output: 2
        System.out.println("Try to find the number 2 in s2: " + s2.find(2).retrieve()); // output: null
        System.out.println("Is there an element behind the first element in s2?: " + s2.findPrevious(5).retrieve()); // output: null

        System.out.println("\nTesting isEmpty and makeEmpty methods...");
        System.out.println("Is s1 empty?: " + s1.isEmpty());
        s1.makeEmpty();
        System.out.println("Is s1 empty after being emptied?: " + s1.isEmpty());
        System.out.println("Is s2 empty?: " + s2.isEmpty());
    }
}
