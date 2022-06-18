package hashMapAPI;

import java.util.HashMap;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 1);
        map.put(5, 2);
        map.put(10, 3);
        map.put(77, 4);
        map.put(22, 5);
        System.out.println(map.size());
        map.remove(22);
        System.out.println(map.size());
    }
}
