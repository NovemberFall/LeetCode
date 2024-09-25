package Math;

import java.util.HashMap;
import java.util.Map;

class _13_RomanToInteger {
    public int romanToInt(String s) {
        // Mapping of Roman numerals to their integer values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // If the current character's value is smaller than the next one, subtract it
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                // Otherwise, add it
                res += roman.get(s.charAt(i));
            }
        }

        return res;
    }
}
