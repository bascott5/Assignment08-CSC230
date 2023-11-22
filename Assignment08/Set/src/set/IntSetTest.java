package set;

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
    }

}
