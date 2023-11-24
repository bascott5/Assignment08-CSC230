package set;
import set.util.*;
public class IntSetTest {

    public static void main(String[] args) {
        IntSet s1 = new IntSet(10);
        try {
            s1.insert(1);
            s1.insert(5);
            s1.insert(77);
            s1.insert(23);
            s1.insert(34);

        } catch (SetException e) {
            System.out.println(e.toString());
        }

        s1.print();

        IntSet s2 = new IntSet(10);
        try {
            s2.insert(77);
            s2.insert(38);
            s2.insert(1);
            s2.insert(29);
            s2.insert(45);
            s2.insert(6);
            s2.insert(33);
        } catch (SetException e) {
            System.out.println(e.toString());
        }

        s2.print();

        GenericComparableSet<Integer> s3 = new GenericComparableSet<>(10);
        LinkedListIterator<Integer> s3marker = s3.zeroth();
            s3.insert(4, s3marker);
            s3.insert(2, s3marker);
            s3.insert(1, s3marker);
            s3.insert(5, s3marker);
            s3.insert(6, s3marker);
        GenericComparableSet<Integer> s4 = new GenericComparableSet<>(10);
        LinkedListIterator<Integer> s4marker = s4.zeroth();
            s4.insert(5, s4marker);
            s4.insert(8, s4marker);
            s4.insert(9, s4marker);
            s4.insert(1, s4marker);
        GenericComparableSet<Integer> s5 = s3.unionLinkedList(s4);
        for(Integer value: s5){
            System.out.println(value);
        }



}
}