package DeepCopy.Assign_ArrayList_to_new_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        List<String> original = new ArrayList<>();
        original.add("foo");
        List<String> copy = new ArrayList<>(original); //shallow copy
        System.out.println(copy.size()); // 1
        original.add("bar");
        System.out.println(copy.size()); // Still 1

    }
}
