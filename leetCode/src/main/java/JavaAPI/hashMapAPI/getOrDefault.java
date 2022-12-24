package JavaAPI.hashMapAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class getOrDefault {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        String str = "a";
        List<Integer> l1 = new ArrayList<>();
        l1.add(100);
        l1.add(200);
        l1.add(300);
        map.put(str, l1);
//        System.out.println(map.get(str));
        List<Integer> l2 = map.getOrDefault(str, new ArrayList<>());
        System.out.println(l2);
    }

    @Test
    void test_getOrDefault() {
        Map<Character, Integer> map = new HashMap<>();
        String str = "ADOBECODEBANC";
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
