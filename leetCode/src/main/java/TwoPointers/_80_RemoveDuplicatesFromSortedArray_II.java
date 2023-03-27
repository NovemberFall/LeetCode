package TwoPointers;

class _80_RemoveDuplicatesFromSortedArray_II {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow - 2]) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}