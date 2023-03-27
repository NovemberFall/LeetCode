package TwoPointers;

import java.util.Arrays;

class _16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int curSum = nums[first] + nums[second] + nums[third];
                if (curSum == target) {
                    return curSum;
                }
                if (Math.abs(target - curSum) < Math.abs(target - closest)) {
                    closest = curSum;
                }
                if (curSum > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
        int[] nums2 = {0, 0, 0};
        System.out.println(threeSumClosest(nums2, 1));
    }
}
