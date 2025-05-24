package Sliding_Window._76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = "ADOBECODEBANC", t = "ABC"
 */
class MinimumWindowSubstring {
    /**
     * Sliding Window
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = buildMap(t);
        int left = 0;
        int start = -1;
        int match = 0;
        int shortest = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            // step 1: Add right
            char cur = s.charAt(right);
            Integer count = map.get(cur);
            // count == null 的情况，当前这个char如果根本不在T 中,
            // 那么以当前fast结尾一定不是最短的 (最短的substring两头的char肯定都在t中)
            if (count != null) {
                if (count == 1) {
                    match++;
                }
                map.put(cur, count - 1);
            }
            // Step 2: move left
            // while 当前sliding window满足条件, move left, 一直移动到第一个不满足条件的left为止
            // while loop 里所有的sliding window都是满足条件的, 所以每一次都可以更新global min
            while (match == map.size()) {
                /*
                0   1   2   3   4
                    4 - 1 + 1 = 4
                 */
                if (right - left + 1 < shortest) {
                    shortest = right - left + 1;
                    start = left;
                }
                cur = s.charAt(left);
                count = map.get(cur);
                if (count != null) {
                    if (count == 0) {
                        match--;
                    }
                    map.put(cur, count + 1);
                }
                left++;
            } // left 在第一个不满足要求的位置
        }
        return shortest == Integer.MAX_VALUE ? "" : s.substring(start, start + shortest);
    }

    private Map<Character, Integer> buildMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        String res = minimumWindowSubstring.minWindow(s, t);
        System.out.println(res); // BANC
    }
}



















