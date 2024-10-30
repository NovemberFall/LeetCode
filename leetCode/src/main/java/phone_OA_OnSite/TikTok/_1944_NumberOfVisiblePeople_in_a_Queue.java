package phone_OA_OnSite.TikTok;

import java.util.ArrayDeque;
import java.util.Deque;

class _1944_NumberOfVisiblePeople_in_a_Queue {
    public int[] canSeePersonsCount(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[heights.length];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[i] > heights[stk.peek()]) {
                stk.pop();
                ans[i]++;
            }
            if (!stk.isEmpty()) {
                ans[i]++;
            }

            stk.push(i);
        }

        return ans;
    }
}
