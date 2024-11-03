package _OA_OnSite_tags.TikTok;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class _907_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev_smaller = new int[n];
        int[] next_smaller = new int[n];
        Arrays.fill(prev_smaller, -1);
        Arrays.fill(next_smaller, n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prev_smaller[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(prev_smaller));
        // [-1, -1, -1, -1, 3, 4, 5, 4]

        stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                next_smaller[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - prev_smaller[i]) * (next_smaller[i] - i) * arr[i];
            ans %= mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        _907_SumOfSubarrayMinimums sumOfSubarrayMinimums = new _907_SumOfSubarrayMinimums();
        int[] arr = new int[]{10, 9, 8, 3, 4, 5, 6, 5};
        sumOfSubarrayMinimums.sumSubarrayMins(arr);
    }
}
