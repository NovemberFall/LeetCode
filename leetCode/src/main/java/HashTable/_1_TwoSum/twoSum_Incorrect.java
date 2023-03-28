package HashTable._1_TwoSum;

import java.util.Arrays;

class twoSum_Incorrect {
    public static int[] twoSum(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int left = 0, right = n - 1;
        while (left < right) {
            int curSum = nums[left] + nums[right];
            if (curSum == target) {
                return new int[]{left, right};
            }
            if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     Correct Ans: new int[] {1, 2}
        因为Arrays.sort(), 让 index 顺序改变了。
     */
    public static void main(String[] args) {
        int[] nums = {11, 15, 2, 7, 9, 10};
        System.out.println(Arrays.toString(twoSum(nums, 9)));

//        int[] nums = {3, 2, 4};
//        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
