package _OA_OnSite_tags.TikTok;

import java.util.Arrays;

class _473_MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return backtracking(matchsticks, new int[4], len, 0);
    }

    private boolean backtracking(int[] nums, int[] sides, int target, int index) {
        if (index == nums.length) {
            return true;
        }
        for (int j = 0; j < 4; j++) {
            if (sides[j] + nums[index] > target) {
                continue;
            }

            sides[j] += nums[index];
            if (backtracking(nums, sides, target, index + 1)) {
                return true;
            }
            sides[j] -= nums[index];

        }
        return false;
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
