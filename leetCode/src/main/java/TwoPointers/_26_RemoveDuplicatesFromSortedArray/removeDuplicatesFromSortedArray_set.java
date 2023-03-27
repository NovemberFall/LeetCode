package TwoPointers._26_RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.Set;

class removeDuplicatesFromSortedArray_set {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int slow = 0;
        set.add(nums[0]);
        for (int fast = 1; fast < nums.length; fast++) {
            if (!set.add(nums[fast])) {
                continue;
            }
            nums[slow + 1] = nums[fast];
            slow++;
        }
        return ++slow;
    }
}
