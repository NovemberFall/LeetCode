package SlideWindow._220_ContainsDuplicate_III;

import java.util.HashMap;
import java.util.Map;

class containsDuplicate_III_bucket {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff == 0 || valueDiff < 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int fast = 0; fast < nums.length; fast++) {
            int bucketIndex = getBucketIndex(nums, fast, valueDiff);
            if (map.put(bucketIndex, nums[fast]) != null) {
                return true;
            }
            Integer left = map.get(bucketIndex - 1);
            if (left != null && nums[fast] - left <= valueDiff) {
                return true;
            }
            Integer right = map.get(bucketIndex + 1);
            if (right != null && right - nums[fast] <= valueDiff) {
                return true;
            }

            if (fast >= indexDiff) {
                map.remove(getBucketIndex(nums, fast - indexDiff, valueDiff));
            }
        }
        return false;
    }

    private int getBucketIndex(int[] nums, int i, int d) {
        return nums[i] < 0 ? nums[i] / (d + 1) - 1 : nums[i] / (d + 1);
    }
}