package SlideWindow._3_LongestSubstrWithoutRepeatChar;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatCharacters_slidingWindow {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, count = 0, longest = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            // > 0 means repeating character
            //if(map[s.charAt(fast++)]-- > 0) count++;
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                count++;
            }

            while (count > 0) {
                //if (map[s.charAt(slow++)]-- > 1) count--;
                char cur = s.charAt(slow);
                if (map.get(cur) > 1) {
                    count--;
                }
                map.put(cur, map.get(cur) - 1);
                slow++;
            }
            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }
}
