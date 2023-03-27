package TwoPointers._27_RemoveElement;

class removeElement_v1 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == val) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}
