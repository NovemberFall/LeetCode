package Monotonic_Stack._84_LargestRectangleHistogram;

import java.util.Stack;

class largestRectangleHistogram_v0 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int max = 0;
        int curIndex = 0;
        while (curIndex < heights.length) {
            while (stk.peek() != -1 && heights[stk.peek()] >= heights[curIndex]) {
                max = Math.max(max, heights[stk.pop()] * (curIndex - stk.peek() - 1));
            }
            stk.push(curIndex);
            curIndex++;
        }

        while (stk.peek() != -1) {
            max = Math.max(max, heights[stk.pop()] * (curIndex - stk.peek() - 1));
        }
        return max;
    }
}
