package _OA_OnSite_tags.TikTok;

import java.util.Arrays;

class _628_MaximumProduct_of_ThreeNumbers {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
