package TwoPointers._18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _18_4Sum_bruteForce {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for (int first = 0; first < n - 3; first++) {
            for (int second = first + 1; second < n - 2; second++) {
                for (int third = second + 1; third < n - 1; third++) {
                    for (int forth = third + 1; forth < n; forth++) {
                        if (nums[first] + nums[second] + nums[third] + nums[forth] == target) {
                            res.add(Arrays.asList(nums[first] , nums[second] , nums[third] , nums[forth]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
