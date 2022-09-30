package Monotonic_Stack._42_TrappingRainWater;

import java.util.Stack;

class Rain {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        int water = 0, i = 0;
        while (i < height.length) {
            if (stk.isEmpty() || height[i] <= height[stk.peek()]) {
                stk.push(i);
                i++;
            } else {
                int prev = stk.pop();
                if (!stk.isEmpty()) {
                    int minHeight = Math.min(height[stk.peek()], height[i]);
                    water += (height[stk.peek()] - height[prev]) * (i - stk.peek() - 1);
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Rain rain = new Rain();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = rain.trap(height);
        System.out.println(res);
    }
}
