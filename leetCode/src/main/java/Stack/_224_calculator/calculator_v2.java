package Stack._224_calculator;

import java.util.Stack;

class calculator_v2 {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                num = 0; // reset the number
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0; // reset the number
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stk.push(res);
                stk.push(sign);
                //reset the sign and result for the value in the parenthesis
                num = 0;
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stk.pop(); // stack.pop() is the sign before the parenthesis
                res += stk.pop(); // /stack.pop() now is the result calculated before the parenthesis
            }
        }

        //Dont' forget the last number   i.g  "1 + 5"
        res += sign * num;
        return res;
    }
}
