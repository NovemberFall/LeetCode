package TwoPointers._1_TwoSum;

import java.util.Arrays;

class _1_TwoSum_Correct {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Integer[] original = new Integer[n];
        for (int i = 0; i < n; i++) {
            original[i] = i;
        }
        Arrays.sort(original, (a, b) -> (nums[a] - nums[b]));
        int left = 0, right = n - 1;
        while (left < right) {
            int curSum = nums[original[left]] + nums[original[right]];
            if (curSum == target) {
                return new int[]{original[left], original[right]};
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
