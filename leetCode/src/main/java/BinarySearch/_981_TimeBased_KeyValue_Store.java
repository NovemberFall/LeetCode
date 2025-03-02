package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _981_TimeBased_KeyValue_Store {
    static class Pair {
        String val;
        int time;

        public Pair(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    Map<String, List<Pair>> map;
    public _981_TimeBased_KeyValue_Store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (!map.containsKey(key)) {
            return res;
        }
        List<Pair> values = map.get(key);

        int left = 0, right = values.size() - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (values.get(mid).time <= timestamp) {
                res = values.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
