package DynamicProgramming._53_MaximumSubarray;

public class MaximumSubarray_Kadane {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            globalMax = Math.max(globalMax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return globalMax;
    }
}
