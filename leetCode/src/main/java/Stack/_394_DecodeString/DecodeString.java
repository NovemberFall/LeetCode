package Stack._394_DecodeString;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            // Step 1: If it's a digit, parse the full number
            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            }

            // Step 2: If it's a letter, add to current string
            else if (Character.isLetter(ch)) {
                currentStr.append(ch);
                i++;
            }

            // Step 3: If it's '[', save the current context
            else if (ch == '[') {
                strStack.push(currentStr.toString());
                currentStr = new StringBuilder();
                i++;
            }

            // Step 4: If it's ']', decode and combine
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                String prevStr = strStack.pop();
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < repeatTimes; j++) {
                    repeated.append(currentStr);
                }
                currentStr = new StringBuilder(prevStr + repeated);
                i++;
            }
        }

        return currentStr.toString();
    }
}
