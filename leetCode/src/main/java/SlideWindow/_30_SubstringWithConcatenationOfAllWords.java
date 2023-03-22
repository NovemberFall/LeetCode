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
        int n = s.length(), m = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = buildMap(words);
        Map<String, Integer> curMap = new HashMap<>();
        String str = null, tmp = null;

        for (int i = 0; i < wordLen; i++) {
            int count = 0; // remark: reset count
            int start = i;
            for (int r = i; r + wordLen <= n; r += wordLen) {
                str = s.substring(r, r + wordLen);
                if (map.containsKey(str)) {

                    curMap.put(str, curMap.getOrDefault(str, 0) + 1);

                    if (curMap.get(str) <= map.get(str)) {
                        count++;
                    }
                    while (curMap.get(str) > map.get(str)) {
                        tmp = s.substring(start, start + wordLen);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wordLen;

                        if (curMap.get(tmp) < map.get(tmp)) {
                            count--;
                        }
                    }
                    if (count == m) {
                        res.add(start);
                        tmp = s.substring(start, start + wordLen);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wordLen;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    start = r + wordLen; //not contain, so move the start
                }
            }
            curMap.clear();
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
