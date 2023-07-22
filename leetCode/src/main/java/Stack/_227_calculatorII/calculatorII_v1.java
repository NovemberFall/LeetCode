package Stack._227_calculatorII;

import java.util.ArrayDeque;
import java.util.Deque;

class calculatorII_v1 {
    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0)  return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            if (c == ' ' && i != len - 1) {
                continue;
            }
            if (!Character.isDigit(c) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        calculatorII_v1 calculatorII = new calculatorII_v1();

        String s = "3+2*2";
        System.out.println(calculatorII.calculate(s)); // 7
        s = " 3+5 / 2 ";
        System.out.println(calculatorII.calculate(s)); // 5
        s = "5 - 3 - 2";
        System.out.println(calculatorII.calculate(s));
    }
}
