package phone_OA_OnSite.Amazon;

import java.util.HashSet;
import java.util.Set;

class _K_Consecutive_Packages {
    public static int maximumSubarraySum(int[] nums, int k) {
        int start = 0;
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int end = 0; end < nums.length; end++) {
            int val = nums[end];
            while (set.contains(val) || end - start + 1 > k) {
                sum -= nums[start];
                set.remove(nums[start++]);
            }
            sum += val;
            set.add(val);

            if (end - start + 1 == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] packages = new int[]{1, 5, 4, 2, 9, 9, 9};
        int res = maximumSubarraySum(packages, 3);
        System.out.println(res);
    }
}
