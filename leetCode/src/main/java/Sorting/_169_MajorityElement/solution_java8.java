package Sorting._169_MajorityElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class solution_java8 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        return Collections.max(map.entrySet(), (e1, e2) ->
                (e1.getValue() - e2.getValue())).getKey();

//        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
