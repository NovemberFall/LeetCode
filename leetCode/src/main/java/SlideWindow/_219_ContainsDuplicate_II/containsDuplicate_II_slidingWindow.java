package SlideWindow._219_ContainsDuplicate_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class containsDuplicate_II_slidingWindow {
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
