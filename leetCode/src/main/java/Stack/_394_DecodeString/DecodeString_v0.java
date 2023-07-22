package Stack._394_DecodeString;

import java.util.Stack;

class DecodeString_v0 {
    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
//                System.out.println("idx: " + idx);
//                System.out.println(res);
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
//                StringBuilder temp = new StringBuilder (resStack.pop());
                StringBuilder temp = new StringBuilder ();
                temp.append(resStack.pop());
                System.out.println(temp);
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
//                System.out.println(res);
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
