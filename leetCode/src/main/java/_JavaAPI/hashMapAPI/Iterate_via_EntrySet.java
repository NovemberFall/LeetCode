package _JavaAPI.hashMapAPI;

import java.util.Map;
import java.util.TreeMap;

class Iterate_via_EntrySet {
    public static void main(String[] args) {
        Map<Integer, String> timeMap = new TreeMap<>();
        timeMap.put(3, "hello");
        timeMap.put(2, "world");
        timeMap.put(1, "hello");
        for (Map.Entry<Integer, String> entry : timeMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
