package Math._772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;

class _Basic_Calculator_III {
    int index = 0;
    public int calculate(String s) {
        return evaluate(s + "+");
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
            } else if (curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/') {
                if (lastOperator == '+') {
                    stack.push(curNum);
                } else if (lastOperator == '-') {
                    stack.push(-curNum);
                } else if (lastOperator == '*') {
                    stack.push(stack.pop() * curNum);
                } else if (lastOperator == '/') {
                    stack.push(stack.pop() / curNum);
                }
                lastOperator = curChar;
                curNum = 0;
            } else if (curChar == ')') {
                break;
            }
        }

        if (lastOperator == '+') {
            stack.push(curNum);
        } else if (lastOperator == '-') {
            stack.push(-curNum);
        } else if (lastOperator == '*') {
            stack.push(stack.pop() * curNum);
        } else if (lastOperator == '/') {
            stack.push(stack.pop() / curNum);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
