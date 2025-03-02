package Design._981_TimeBased_KeyValue_Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeBased_KeyValue_Store {
    static class Pair {
        String value;
        int time;

        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    Map<String, List<Pair>> map;

    public TimeBased_KeyValue_Store() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> currentKeyList = map.get(key);
        int index = largestSmallerOrEqual(timestamp, currentKeyList);
        if (index == -1) {
            return "";
        }
        return currentKeyList.get(index).value;
    }

    private int largestSmallerOrEqual(int timestamp, List<Pair> currentKeyList) {
        int left = 0, right = currentKeyList.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (currentKeyList.get(mid).time <= timestamp) {
                left = mid;
            }  else {
                right = mid - 1;
            }
        }
        if (currentKeyList.get(right).time <= timestamp) {
            return right;
        }
        if (currentKeyList.get(left).time <= timestamp) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        TimeBased_KeyValue_Store tbkvs = new TimeBased_KeyValue_Store();
        tbkvs.set("foo", "bar", 1);
        tbkvs.set("foo", "bar", 2);
        tbkvs.set("foo", "bar", 3);
        System.out.println(tbkvs.get("foo", 2));
        System.out.println(tbkvs.get("foo", 5));
        System.out.println(tbkvs.get("foo", 6));
        tbkvs.set("foo", "bar2", 7);
        tbkvs.set("foo", "bar4", 15);
        System.out.println(tbkvs.get("foo", 9));
        System.out.println(tbkvs.get("foo", 12));
        System.out.println(tbkvs.get("foo", 14));
    }
}
