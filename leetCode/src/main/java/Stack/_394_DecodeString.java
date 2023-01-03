package Stack;

import java.util.Stack;

public class _394_DecodeString {
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

//    public static String decodeString(String s) {
//        if (s.length() == 0) return "";
//        Stack<String> st = new Stack<>();
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c >= '0' && c <= '9')
//                num = num * 10 + c - '0';
//            else if (c == '[') {
//                st.push(num + "");
//                st.push("["); //use [ as a marker so we don't have to check whether an item is a number or not
//                num = 0;
//            } else if (c == ']') {
//                String str = "";
//                //keep pop until meet '['
//                while (st.peek() != "[") {
//                    str = st.pop() + str;
//                }
//                st.pop(); //pop '['
//                int repeat = Integer.valueOf(st.pop());
//                StringBuilder sb = new StringBuilder();
//                for (int k = 0; k < repeat; k++) {
//                    sb.append(str);
//                }
//                st.push(sb.toString());
//            } else
//                st.push(c + "");
//        }
//
//        String ans = "";
//        while (!st.isEmpty()) ans = st.pop() + ans;
//        return ans;
//    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
