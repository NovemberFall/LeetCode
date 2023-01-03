package Stack;

import java.util.Stack;

class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stk.isEmpty() || stk.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stk.isEmpty() || stk.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stk.isEmpty() || stk.pop() != '{') {
                    return false;
                }
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String str =  "()[]{}";
        _20_ValidParentheses validParentheses = new _20_ValidParentheses();
        boolean ans = validParentheses.isValid(str);
        System.out.println(ans);
    }
}
