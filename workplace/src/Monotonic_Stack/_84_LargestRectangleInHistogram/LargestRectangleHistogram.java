//package Monotonic_Stack._84_LargestRectangleInHistogram;
//
//import java.util.Stack;
//
//class LargestRectangleHistogram {
//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stk = new Stack<>();
//
//        int area_with_top;
//        int max_area = 0, i = 0;
//        while (i < heights.length) {
//            if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
//                stk.push(i);
//                i++;
//            } else {
//                int temp = stk.pop();
//                int maxHeight
//            }
//        }
//    }
//}
