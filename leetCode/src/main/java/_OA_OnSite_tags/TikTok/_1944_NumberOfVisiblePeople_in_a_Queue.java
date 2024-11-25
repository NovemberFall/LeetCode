package _OA_OnSite_tags.TikTok;


import java.util.Stack;

class _1944_NumberOfVisiblePeople_in_a_Queue {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n]; // To store the number of visible people for each person
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack to store indices

        for (int i = 0; i < n; i++) {
            // Process all people in the stack shorter than the current person
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                result[stack.pop()]++; // Increment visible count for the shorter person
            }
            // If the stack is not empty, the current person blocks the view of the top of the stack
            if (!stack.isEmpty()) {
                result[stack.peek()]++;
            }
            // Push the current person's index onto the stack
            stack.push(i);
        }

        return result;
    }
}


















//class _1944_NumberOfVisiblePeople_in_a_Queue {
//    public int[] canSeePersonsCount(int[] heights) {
//        if (heights == null || heights.length == 0) {
//            return new int[]{};
//        }
//
//        int[] ans = new int[heights.length];
//        Deque<Integer> stk = new ArrayDeque<>();
//        for (int i = heights.length - 1; i >= 0; i--) {
//            while (!stk.isEmpty() && heights[i] > heights[stk.peek()]) {
//                stk.pop();
//                ans[i]++;
//            }
//            if (!stk.isEmpty()) {
//                ans[i]++;
//            }
//
//            stk.push(i);
//        }
//
//        return ans;
//    }
//}
