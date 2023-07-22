package Stack._224_calculator;

import java.util.Stack;

class calculator_v1 {
    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(chars[i])) {
                int num = chars[i] - '0';
                while (i < len - 1 && Character.isDigit(chars[i + 1])) {
                    num = num * 10 + (chars[++i] - '0');
                }
                res += sign * num;
            } else if (chars[i] == '+') {
                sign = 1;
            } else if (chars[i] == '-') {
                sign = -1;
            } else if (chars[i] == '(') {
                //we push the result first, then sign;
                stack.push(res);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                res = 0;
                sign = 1;
            } else if (chars[i] == ')') {
                res *= stack.pop();
                res += stack.pop();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        calculator_v1 calculator = new calculator_v1();
        String s = " 2-1 + 2 ";
        System.out.println(calculator.calculate(s)); // 3
        String s2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator.calculate(s2)); // 23
        String s3 = "15 + 35 + (5 - 4)";
        System.out.println(calculator.calculate(s3)); // 51
        String s4 = "-45 + 45 + (10 - 5)";
        System.out.println(calculator.calculate(s4)); // 5
    }
}
