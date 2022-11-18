package TwoPointers._15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _15_3Sum_List {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int curSum = nums[first] + nums[second] + nums[third];
                if (curSum == 0) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (curSum < 0) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return res;
    }
}
