package Sliding_Window._220_ContainsDuplicate_III;

import java.util.TreeSet;

class containsDuplicate_III_treeSet {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0) return true;

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int fast = 0; fast < nums.length; fast++) {
            Integer floor = treeSet.floor(nums[fast]);
            if (floor != null && nums[fast] - floor <= valueDiff) {
                return true;
            }
            Integer ceiling = treeSet.ceiling(nums[fast]);
            if (ceiling != null && ceiling - nums[fast] <= valueDiff) {
                return true;
            }

            treeSet.add(nums[fast]);
            if (fast >= indexDiff) {
                treeSet.remove(nums[fast - indexDiff]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicate_III_treeSet containsDuplicateIii = new containsDuplicate_III_treeSet();
        int[] nums = new int[]{1, 5, 9, 1, 5, 9};
        boolean res = containsDuplicateIii.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(res); // false
    }
}
