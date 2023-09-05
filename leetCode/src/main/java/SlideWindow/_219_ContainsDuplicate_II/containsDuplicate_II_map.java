package SlideWindow._219_ContainsDuplicate_II;

import java.util.HashMap;
import java.util.Map;

class containsDuplicate_II_map {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
