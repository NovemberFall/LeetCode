package JavaAPI.TreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class test_key {
    public static void main(String[] args) {
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        tmap.putIfAbsent(15, new ArrayList<>());
        tmap.putIfAbsent(1, new ArrayList<>());
        tmap.putIfAbsent(3, new ArrayList<>());
        tmap.putIfAbsent(100, new ArrayList<>());
        tmap.putIfAbsent(9, new ArrayList<>());
        tmap.putIfAbsent(8, new ArrayList<>());
        tmap.putIfAbsent(7, new ArrayList<>());
        tmap.putIfAbsent(6, new ArrayList<>());
        tmap.putIfAbsent(5, new ArrayList<>());
        tmap.putIfAbsent(2, new ArrayList<>());

        for (int key : tmap.keySet()) {
            System.out.println(key);
        }

        System.out.println(tmap.lastKey());
    }
}
