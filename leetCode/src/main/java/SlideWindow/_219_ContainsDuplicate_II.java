package SlideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class _219_ContainsDuplicate_II {
    public boolean containsNearbyDuplicate_Self(int[] nums, int k) {
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

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;

        Set<Integer> set = new HashSet<>();
        for (int fast = 0; fast < nums.length; fast++) {
            if (!set.add(nums[fast])) {
                return true;
            }
            if (fast >= k) {
                set.remove(nums[fast - k]);
            }
        }
        return false;
    }
}
