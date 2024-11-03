package _OA_OnSite_tags.TikTok;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: s = "()())()" --> ["(())()","()()()"]
 * <p>
 * Input: s = "(a)())()" --> ["(a())()","(a)()()"]
 * <p>
 * Input: s = ")("  --> [""]
 */
class _301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void helper(List<String> res, String s, int left, int right, char[] pair) {
        System.out.println("Current s is " + s);
        int stack = 0;
        for (; right < s.length(); right++) {
            if (s.charAt(right) == pair[0]) stack++;
            if (s.charAt(right) == pair[1]) stack--;

            if (stack < 0) {
                //If stack becomes negative, it means there are more `)` than `(`, indicating an invalid parentheses sequence.
                break; // The break statement is executed, immediately exiting the for loop.
            }
        }
        if (stack < 0) { // `)` is more than `(`
            for (; left <= right; left++) {
                if (s.charAt(left) != pair[1]) continue;

                if (left > 1 && s.charAt(left) == s.charAt(left - 1))  continue;

                // remove first `)` from `( ) )`
                helper(res, s.substring(0, left) + s.substring(left + 1), left, right, pair);
            }
        } else if (stack > 0) { // `(` is more than `)`
            // 一整个String 反过来了，当然 left, right 也从 0 开始处理
            helper(res, new StringBuilder(s).reverse().toString(), 0, 0, new char[]{')','('});
        } else if (stack == 0) {
            res.add(pair[0] == '(' ? s : new StringBuilder(s).reverse().toString());
        }
    }

    public static void main(String[] args) {
//        String str = "(a)())()";
//        System.out.println(new StringBuilder(str).reverse().toString()); // `)())()a(`
//        str = "((())";
//        System.out.println(new StringBuilder(str).reverse().toString()); // `))(((`
        _301_RemoveInvalidParentheses invalidParentheses = new _301_RemoveInvalidParentheses();
        invalidParentheses.removeInvalidParentheses("()())()");
    }
}
