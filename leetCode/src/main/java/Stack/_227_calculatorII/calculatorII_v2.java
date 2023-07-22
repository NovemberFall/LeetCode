package Stack._227_calculatorII;

import java.util.Stack;

public class calculatorII_v2 {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        String str = s.trim();
        int len = str.length();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == len - 1) {
                if (sign == '+') {
                    stk.push(num);
                } else if (sign == '-') {
                    stk.push(-num);
                } else if (sign == '*') {
                    stk.push(stk.pop() * num);
                } else if (sign == '/') {
                    stk.push(stk.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        for (Integer i : stk) {
            res += i;
        }
        return res;
    }
}
