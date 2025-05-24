package Sliding_Window._76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

class minimumWindowSubstring_BruteForce {

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";

        int resLen = Integer.MAX_VALUE;
        String res = "";
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char tc : t.toCharArray()) {
            map.put(tc, map.getOrDefault(tc, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                boolean includeTstr = check(map, sb.toString());
                if (includeTstr) {
                    if (sb.length() < resLen) {
                        resLen = sb.length();
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }

    private boolean check(Map<Character, Integer> map, String sub) {
        boolean res = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = 0;
            for (char c : sub.toCharArray()) {
                if (entry.getKey() == c) {
                    count++;
                }
            }
            if (count < entry.getValue()) {
                res = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minimumWindowSubstring_BruteForce minimumWindowSubstringBruteForce = new minimumWindowSubstring_BruteForce();
        String res = minimumWindowSubstringBruteForce.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
