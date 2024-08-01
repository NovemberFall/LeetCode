package phone_OA_OnSite.TikTok;

import java.util.Stack;

class _227_BasicCalculator_II {
    public int calculate(String s) {
        s = s.trim();
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    stack.push(num);
                    lastSign = c;
                } else if (lastSign == '-') {
                    stack.push(-num);
                    lastSign = c;
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                    lastSign = c;
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                    lastSign = c;
                }
                num = 0;
            }
        }
        int sum = 0;
        for (int e : stack) {
            sum += e;
        }
        return sum;
    }
}
