package _Java8.forEach_Filter;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//filter => conditional check
public class FilterDemo {

    @Test
    void testFilter() {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("piter");
        list.add("mark");
        list.add("mac");

        for (String s : list) {
            if (s.startsWith("m")) {
                System.out.println(s);
            }
        }
    }


    @Test
    void testFilter2() {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("piter");
        list.add("mark");
        list.add("mac");

        list.stream().filter((t) -> t.startsWith("m")).forEach(
                t -> System.out.println(t)
        );
    }


    @Test
    void testFilter3() {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("piter");
        list.add("mark");
        list.add("mac");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.entrySet()
                .stream()
                .filter(entry -> entry.getKey() % 2 == 0)
                .forEach(obj -> System.out.println(obj));
    }
}
