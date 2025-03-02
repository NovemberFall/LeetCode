package Design._981_TimeBased_KeyValue_Store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeBased_KeyValue_Store_TreeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeBased_KeyValue_Store_TreeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
