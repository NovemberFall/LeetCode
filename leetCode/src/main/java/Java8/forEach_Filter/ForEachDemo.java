package Java8.forEach_Filter;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class ForEachDemo {
    @Test
    void testForEach() {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("Piter");
        list.add("Mark");
        list.add("Mac");

        for (String s : list) {
            System.out.println(s);
        }

        list.stream().forEach(t -> System.out.println(t));
    }


    @Test
    void testForEachMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach((key, value) -> System.out.println(key + " : " + value));
        map.entrySet().stream().forEach(obj -> System.out.println(obj));
    }


    @Test
    void testForEach3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach((key, value) -> System.out.println(key + " : " + value));
        map.entrySet().stream().forEach(obj -> System.out.println(obj));

        Consumer<String> consumer = (t) -> System.out.println(t);
        consumer.accept("Java 8 consumer");
    }


    @Test
    void testForEach4() {
        List<String> list = new ArrayList<>();
        list.add("Murrit");
        list.add("John");
        list.add("Piter");
        list.add("Mark");
        list.add("Mac");


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach((key, value) -> System.out.println(key + " : " + value));
        map.entrySet().stream().forEach(obj -> System.out.println(obj));

        Consumer<String> consumer = (t) -> System.out.println(t);
        for (String s : list) {
            consumer.accept(s);
        }
    }
}
