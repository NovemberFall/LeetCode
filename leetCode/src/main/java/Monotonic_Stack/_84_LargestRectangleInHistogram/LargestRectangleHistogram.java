package Monotonic_Stack._84_LargestRectangleInHistogram;

import java.util.Stack;

/*
1. Create an empty stack.
2. Start from the first bar, and do the following for every bar hist[i] where ‘i‘ varies from 0 to n-1
    1. If the stack is empty or hist[i] is higher than the bar at top of the stack, then push ‘i‘ to stack.
    2. If this bar is smaller than the top of the stack, then keep removing the top of the stack while
        the top of the stack is greater.
    3. Let the removed bar be hist[tp]. Calculate the area of the rectangle with hist[tp] as the smallest bar.
    4. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack
        and ‘right index’ is ‘i‘ (current index).
3. If the stack is not empty, then one by one remove all bars from the stack and
    do step (2.2 and 2.3) for every removed bar

 */
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
