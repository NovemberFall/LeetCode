package TwoPointers;

import java.util.Arrays;

/*  Quick Sort:

    {1} --> {1}
    {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
                     or {1, 1, 3, 0, 0}
                     or {3, 1, 1, 0, 0}
 */
public class moveZerosToTheEnd {
        public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] != 0) {
                left++;
            } else if (nums[right] == 0) {
                right--;
            } else if (nums[left] == 0 && nums[right] != 0) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 3, 0, 1};
        moveZerosToTheEnd mztte = new moveZerosToTheEnd();
        mztte.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
