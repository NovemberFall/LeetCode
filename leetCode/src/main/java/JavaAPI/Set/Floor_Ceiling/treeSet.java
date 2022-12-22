package JavaAPI.Set.Floor_Ceiling;

import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class treeSet {

    /**
     * The `floor()` method of TreeSet class is used to find an element
     * which is less than or equal to the given element in the argument list.
     */
    @Test
    void test_floor() {
        TreeSet<Integer> obj = new TreeSet<Integer>();
        obj.add(2);
        obj.add(8);
        obj.add(5);
        obj.add(1);
        obj.add(10);
        System.out.println("TreeSet: " + obj);
        System.out.println("floor value of 3 in set: " + obj.floor(3));
    }

    /**
     * The `ceiling()` is a method of TreeSet class which is used to find element
     * which is greater than or equal to the given element in the argument list.
     */
    @Test
    void test_celing() {
        TreeSet<Integer> obj = new TreeSet<Integer>();
        obj.add(2);
        obj.add(8);
        obj.add(5);
        obj.add(1);
        obj.add(10);
        System.out.println("TreeSet: " + obj);
        System.out.println("Ceiling value of 4 in set: " + obj.ceiling(4));
    }
}
