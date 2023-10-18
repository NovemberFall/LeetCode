package LinkedList;

class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int tortoise = 0;
        while (true) {
            slow = nums[slow];
            tortoise = nums[tortoise];
            if (slow == tortoise) {
                break;
            }
        }
        return slow;
    }
}
