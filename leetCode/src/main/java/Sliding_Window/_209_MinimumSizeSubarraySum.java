package Sliding_Window;

class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                curSum -= nums[left];
                left++;
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
