package phone_OA_OnSite.TikTok._1062_LongestRepeatingSubstring;

import java.util.HashSet;
import java.util.Set;

class bruteForce {
    public int longestRepeatingSubstring(String s) {
        if (s.length() == 0) return 0;

        int len = s.length() - 1;
        Set<String> set = new HashSet<>();
        while (len > 0) { // O(N)
            for (int i = 0; i + len <= s.length(); i++) { // O(N)
                String ss = s.substring(i, i + len); // O(N)
                if (set.contains(ss)) {
                    return len;
                }
                set.add(ss);
            }
            len--;
        }
        return 0;
    }
}
