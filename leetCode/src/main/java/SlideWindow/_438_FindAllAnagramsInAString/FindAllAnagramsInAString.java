package SlideWindow._438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        //Record the frequency of occurrence of all letters of p
        int[] pFreq = new int[26];
        for(int i = 0; i < p.length(); i++){
            pFreq[p.charAt(i) - 'a']++;
        }

        //[left right] corresponding to the left and right of window
        int[] window = new int[26];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            if (right - left + 1 == p.length()) {
                if (Arrays.equals(pFreq, window)) {
                    res.add(left);
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString sw = new FindAllAnagramsInAString();
        String l = "abcbac", s = "ab";
        List<Integer> list = sw.findAnagrams(s, l);
        System.out.println(list);
    }
}
