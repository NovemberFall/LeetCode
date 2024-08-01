package PrefixSum._560_SubarraySumEqualsK;

class brute_force {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0]; // Initialize first element directly

        // Calculate prefix sums (starting at index 1)
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        // Find subarrays with sum k
        for (int start = 0; start < preSum.length; start++) {
            for (int end = start + 1; end < preSum.length; end++) {
                if (preSum[end] - preSum[start] == k)
                    count++;
            }
        }
        return count;
    }
}
