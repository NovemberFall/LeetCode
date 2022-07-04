package ObjectOrientedDesign.Calculator;

import java.util.Stack;

public class calculator {
    public static int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(res);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        // Finally if there is only one number, just add num * sign to res
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " 2-1 + 2 ";
        System.out.println(calculate(s)); // 3
        s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s)); // 23
    }
}
