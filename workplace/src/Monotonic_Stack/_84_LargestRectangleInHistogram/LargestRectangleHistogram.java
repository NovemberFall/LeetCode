package Monotonic_Stack._84_LargestRectangleInHistogram;

import java.util.Stack;

class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();

        int area_with_top;
        int max_area = -1, i = 0;
        while (i < heights.length) {
            if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
                stk.push(i);
                i++;
            } else {
                int temp = stk.pop();
                if (stk.isEmpty()) {
                    area_with_top = heights[temp] * i;
                } else {
                    area_with_top = heights[temp] * (i - stk.peek() - 1);
                }

                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!stk.isEmpty()) {
            int tp = stk.pop();
            if (stk.isEmpty()) {
                area_with_top = heights[tp] * i;
            } else {
                area_with_top = heights[tp] * (i - stk.peek() - 1);
            }

            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        LargestRectangleHistogram lrh = new LargestRectangleHistogram();
        int res = lrh.largestRectangleArea(heights);
        System.out.println(res);
    }
}
