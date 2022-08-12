package Arrays.Arrays_equals_method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class slideWindow {
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();

        //Record the frequency of occurrence of all letters of sh
        int[] shFreq = new int[26];
        for (int i = 0; i < sh.length(); i++) {
            shFreq[sh.charAt(i) - 'a']++;
        }
        //[left right] corresponding to the left and right of window
        int left = 0, right = 0;
        int[] window = new int[26];
        while (right < lo.length()) {
            window[lo.charAt(right) - 'a']++; //increase frequence of letters
            if (right - left + 1 == sh.length()) {
                if (Arrays.equals(window, shFreq)) {
                    res.add(left);
                }
                window[lo.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        slideWindow sw = new slideWindow();
        String l = "abcbac", s = "ab";
        List<Integer> list = sw.allAnagrams(s, l);
        System.out.println(list);
    }
}
