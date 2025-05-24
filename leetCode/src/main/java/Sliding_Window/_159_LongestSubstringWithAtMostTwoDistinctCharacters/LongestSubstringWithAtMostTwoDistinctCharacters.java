package Sliding_Window._159_LongestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.keySet().size() > 2) {
                char tmp = s.charAt(left);
                map.put(tmp, map.get(tmp) - 1);
                if (map.get(tmp) == 0) {
                    map.remove(tmp);
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
