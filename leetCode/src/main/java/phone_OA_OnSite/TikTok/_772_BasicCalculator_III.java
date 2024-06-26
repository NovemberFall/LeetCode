package phone_OA_OnSite.TikTok;

import java.util.ArrayDeque;
import java.util.Queue;

class _772_BasicCalculator_III {
    public int calculate(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.offer(' '); // placeholder
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        int num = 0, prev = 0, sum = 0;
        char prevOp = '+';

        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(queue);
            } else {
                if (prevOp == '+') {
                    sum += prev;
                    prev = num;
                } else if (prevOp == '-') {
                    sum += prev;
                    prev = -num;
                } else if (prevOp == '*') {
                    prev *= num;
                } else if (prevOp == '/') {
                    prev /= num;
                }

                if (c == ')') {
                    break;
                }
                prevOp = c;
                num = 0;
            }
        }
        return sum + prev;
    }
}
