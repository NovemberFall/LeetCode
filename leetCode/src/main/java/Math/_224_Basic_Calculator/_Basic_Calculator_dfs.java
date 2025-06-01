package Math._224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

class _Basic_Calculator_dfs {
    int index = 0;
    public int calculate(String s) {
        return evaluate(s);
    }

    private int evaluate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int curNum = 0;
        char lastOperator = '+';
        while (index < s.length()) {
            char curChar = s.charAt(index);
            index++;
            if (curChar == ' ') {
                continue;
            }
            if (Character.isDigit(curChar)) {
                curNum = curNum * 10 + curChar - '0';
            } else if (curChar == '(') {
                curNum = evaluate(s);
            } else if (curChar == '+' || curChar == '-'){ // curChar must be one of " +, -, *, / " or ")"
                if (lastOperator == '+') {
                    stack.push(curNum);
                } else if (lastOperator == '-') {
                    stack.push(-curNum);
                }
                lastOperator = curChar;
                curNum = 0;
            } else if (curChar == ')') {
                break;
            }
        }

        // ✅ Final processing to handle the last number
        if (lastOperator == '+') {
            stack.push(curNum);
        } else if (lastOperator == '-') {
            stack.push(-curNum);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
