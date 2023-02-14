package Monotonic_Stack._84_LargestRectangleInHistogram;

import java.util.Stack;

class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();

        int areaWithTop;
        int maxArea = -1, i = 0;
        while (i < heights.length) {
            if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
                stk.push(i);
                i++;
            } else {
                int temp = stk.pop();
                if (stk.isEmpty()) {
                    areaWithTop = heights[temp] * i;
                } else {
                    areaWithTop = heights[temp] * (i - stk.peek() - 1);
                }

                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        while (!stk.isEmpty()) {
            int tp = stk.pop();
            if (stk.isEmpty()) {
                areaWithTop = heights[tp] * i;
            } else {
                areaWithTop = heights[tp] * (i - stk.peek() - 1);
            }

            maxArea = Math.max(maxArea, areaWithTop);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        LargestRectangleHistogram lrh = new LargestRectangleHistogram();
        int res = lrh.largestRectangleArea(heights);
        System.out.println(res);
    }
}
