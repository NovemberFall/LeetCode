package TwoPointers._15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _15_3Sum_Set {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
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
                } else if (curSum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
