package Sorting._912_SortAnArray;

import java.util.Arrays;

/*
    https://www.youtube.com/watch?v=8mJ-OhcfpYg
 */
class InsertionSort {
    public static void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 7, 4, 2, 9, 8, 5, 3};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
