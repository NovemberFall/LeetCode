package SlideWindow._3_LongestSubstrWithoutRepeatChar;

import java.util.HashSet;
import java.util.Set;

class _3_LongestSubstringWithoutRepeatCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int globalMax = 0;
        int fast = 0, slow = 0;
        while (fast < s.length()) {
            if (!set.contains(chars[fast])) {
                set.add(chars[fast++]);
            } else {
                set.remove(chars[slow++]);
            }
            globalMax = Math.max(globalMax, set.size());
        }
        return globalMax;
    }

    public static void main(String[] args) {
        _3_LongestSubstringWithoutRepeatCharacters lswrc = new _3_LongestSubstringWithoutRepeatCharacters();
        int res = lswrc.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res); // 3
    }
}
