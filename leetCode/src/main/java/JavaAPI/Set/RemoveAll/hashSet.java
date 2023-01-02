package JavaAPI.Set.RemoveAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class hashSet {
    public static void main(String[] args) {
        // Creating object of Set
        Set<Integer> set1 = new HashSet<Integer>();

        // Populating set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        // print set1
        System.out.println("Set before removeAll() operation : " + set1);

        // Creating another object of Set
        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        // print set2
        System.out.println("Collection Elements to be removed : " + set2);

        // Removing elements from set
        // specified in set2
        // using removeAll() method
        set1.removeAll(set2);

        // print set1
        System.out.println("Set after removeAll() operation : " + set1);
    }
}
