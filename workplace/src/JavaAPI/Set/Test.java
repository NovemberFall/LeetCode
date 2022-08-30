package JavaAPI.Set;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hello");
        dict.add("world");
        dict.add("cat");
        dict.add("rat");
        dict.add("hat");
        boolean flag = dict.contains("h");
        System.out.println(flag);
    }
}
