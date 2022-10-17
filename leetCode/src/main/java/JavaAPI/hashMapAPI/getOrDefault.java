package JavaAPI.hashMapAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
