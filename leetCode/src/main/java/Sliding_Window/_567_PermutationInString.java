package Sliding_Window;

import java.util.Arrays;

class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        int left = 0, right = s1.length();
        while (right < s2.length()) {
            count2[s2.charAt(right) - 'a']++;
            count2[s2.charAt(left) - 'a']--;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
