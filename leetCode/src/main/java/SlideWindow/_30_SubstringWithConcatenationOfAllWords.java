package SlideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return res;
        }
        int n = s.length(), wordNums = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> seen = buildMap(words);
        Map<String, Integer> curSeen = new HashMap<>();
        String str = null, tmp = null;

        for (int i = 0; i < wordLen; i++) {
            int count = 0; // remark: reset count
            int start = i;
            for (int r = i; r + wordLen <= n; r += wordLen) {
                str = s.substring(r, r + wordLen);
                if (seen.containsKey(str)) {

                    curSeen.put(str, curSeen.getOrDefault(str, 0) + 1);
                    count++;

                    while (curSeen.get(str) > seen.get(str)) {
                        tmp = s.substring(start, start + wordLen);
                        curSeen.put(tmp, curSeen.get(tmp) - 1);
                        start += wordLen;

                        count--;
                    }
                } else {
                    curSeen.clear();
                    count = 0;
                    start = r + wordLen; //not contain, so move the start
                }
                if (count == wordNums) {
                    res.add(start);
                }
            }
            curSeen.clear();
        }
        return res;
    }

    private Map<String, Integer> buildMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
