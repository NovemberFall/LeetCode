package PrefixSum._560_SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

class _560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        // calculate prefix sum
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            if (preSum.containsKey(sum[i] - k)) {
                count += preSum.get(sum[i] - k);
            }
            preSum.put(sum[i], preSum.getOrDefault(sum[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _560_SubarraySumEqualsK subarraySumEqualsK = new _560_SubarraySumEqualsK();
        int res = subarraySumEqualsK.subarraySum(new int[]{1, 2, 3}, 3);
        System.out.println(res);
    }
}
