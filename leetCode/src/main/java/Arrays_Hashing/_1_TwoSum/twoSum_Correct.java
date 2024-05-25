package Arrays_Hashing._1_TwoSum;

import java.util.Arrays;

class twoSum_Correct {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Integer[] original = new Integer[n];
        for (int i = 0; i < n; i++) {
            original[i] = i;
        }
        Arrays.sort(original, (index_a, index_b) -> (nums[index_a] - nums[index_b]));
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
