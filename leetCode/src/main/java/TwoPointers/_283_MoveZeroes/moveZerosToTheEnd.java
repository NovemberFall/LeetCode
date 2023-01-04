package TwoPointers._283_MoveZeroes;

import java.util.Arrays;

class moveZerosToTheEnd {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }

        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 3, 0, 1};
        moveZerosToTheEnd mztte = new moveZerosToTheEnd();
        mztte.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 1, 0, 0]
    }
}
