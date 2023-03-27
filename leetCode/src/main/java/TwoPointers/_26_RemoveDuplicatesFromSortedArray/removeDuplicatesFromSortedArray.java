package TwoPointers._26_RemoveDuplicatesFromSortedArray;

class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                continue;
            }
            nums[slow + 1] = nums[fast];
            slow++;
        }
        return ++slow;
    }
}
