package TwoPointers._18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _18_4Sum_Set {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        long tar = (long) target;
        int n = nums.length;
        if (n < 4) {
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        for (int first = 0; first < n - 3; first++) {
            for (int second = first + 1; second < n - 2; second++) {
                int third = second + 1;
                int fourth = n - 1;
                while (third < fourth) {
                    long curSum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (curSum == tar) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                        fourth--;
                    } else if (curSum < tar) {
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
}
