package Java8.getMaxKey;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class getMaxKey_java8 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }

        return Collections.max(map.entrySet(), (e1, e2) ->
                (e1.getValue() - e2.getValue())).getKey();
    }

    public static void main(String[] args) {
        getMaxKey_java8 getMaxKey_java8 = new getMaxKey_java8();
        int res = getMaxKey_java8.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(res);

        res = getMaxKey_java8.majorityElement(new int[]{1, 1, 1, 1, 2, 3, 4});
        System.out.println(res);
    }
}
