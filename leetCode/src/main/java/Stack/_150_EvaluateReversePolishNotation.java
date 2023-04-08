package Stack;

import java.util.Stack;

class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int right, left;
        Stack<Integer> stk = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                stk.add(stk.pop() + stk.pop());
            } else if (str.equals("-")) {
                right = stk.pop();
                left = stk.pop();
                stk.add(left - right);
            } else if (str.equals("*")) {
                stk.add(stk.pop() * stk.pop());
            } else if (str.equals("/")) {
                right = stk.pop();
                left = stk.pop();
                stk.add(left / right);
            } else {
                stk.add(Integer.valueOf(str));
            }
        }
        return stk.pop();
    }
}
