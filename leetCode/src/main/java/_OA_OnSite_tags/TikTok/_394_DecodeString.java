package _OA_OnSite_tags.TikTok;

import java.util.Stack;

class _394_DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                StringBuilder substr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop()); // Reverse the order in Java
                }
                stack.pop(); // Pop the "["

                StringBuilder kStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    kStr.insert(0, stack.pop()); // Reverse the order in Java
                }
                int k = Integer.parseInt(kStr.toString());

                StringBuilder repeatedSubstr = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    repeatedSubstr.append(substr);
                }
                stack.push(repeatedSubstr.toString());
            }
        }

        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        return result.toString();
    }
}
