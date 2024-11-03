package _OA_OnSite_tags.TikTok._456_132Pattern;

import java.util.Stack;

class _132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();  // Use Stack for [num, minLeft] pairs
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            while (!stack.isEmpty() && n >= stack.peek()[0]) {
                stack.pop(); // Pop while n >= stack top's num
            }
            if (!stack.isEmpty() && n > stack.peek()[1]) {
                return true; // Found 132 pattern
            }

            stack.push(new int[]{n, curMin}); // Push [n, curMin] onto the stack
            curMin = Math.min(curMin, n);     // Update curMin
        }

        return false; // No 132 pattern found
    }
}
