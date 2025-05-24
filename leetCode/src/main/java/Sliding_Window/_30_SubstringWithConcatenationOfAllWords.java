package Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Sliding window + double HashMap optimization
    The key is that we only need to iterate through the substring starting at indices 0 to wordLen-1,
    and then maintain valid substrings as we iterate.
    The core logic is to dynamically maintain and search for valid substrings based on the current count.
    Time complexity: O(N), Space complexity: O(N)
*/
class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return res;
        }
        int n = s.length();
        int wordLen = words[0].length();
        Map<String, Integer> seen = buildMap(words);

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            int count = 0; // remark: reset count
            Map<String, Integer> curSeen = new HashMap<>();

            while (right + wordLen <= n) {
                String cur = s.substring(right, right + wordLen);
                right += wordLen;

                if (seen.containsKey(cur)) {
                    curSeen.put(cur, curSeen.getOrDefault(cur, 0) + 1);
                    count++;

                    while (curSeen.get(cur) > seen.get(cur)) {
                        String delete = s.substring(left, left + wordLen);
                        curSeen.put(delete, curSeen.get(delete) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    left = right;
                    curSeen.clear();
                    count = 0;
                }
                if (count == words.length) {
                    res.add(left);
                }
            }

        }
        return res;
    }

    // 存储words的单词和个数
    private Map<String, Integer> buildMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}

/*
    words = ["bar","foo","the"],   seen[bar: 1, foo: 1, the: 1]

    count = 0   res[ ],   curSeen[bar: 0, foo: 0, the: 0]
    b a r f o o f o o b a r t h e f o o b a r m a n
    l
    r


    count = 1   res[ ]    curSeen[bar: 1, foo: 0, the: 0]
    b a r f o o f o o b a r t h e f o o b a r m a n
    l
          r


    count = 2   res[ ]    curSeen[bar: 1, foo: 1, the: 0]
    b a r f o o f o o b a r t h e f o o b a r m a n
    l
                r


    count = 3   res[ ]    curSeen[bar: 1, foo: 2, the: 0],  since curSeen.get(cur) > seen.get(cur)
    b a r f o o f o o b a r t h e f o o b a r m a n
          l
                      r


    count = 2   res[ ]    curSeen[bar: 0, foo: 2, the: 0],  since curSeen.get(cur) > seen.get(cur)
    b a r f o o f o o b a r t h e f o o b a r m a n
          l
                      r


    count = 1   res[ ]    curSeen[bar: 0, foo: 1, the: 0],  since curSeen.get(cur) > seen.get(cur)
    b a r f o o f o o b a r t h e f o o b a r m a n
                l
                      r


    count = 2   res[ ]    curSeen[bar: 1, foo: 1, the: 0]
    b a r f o o f o o b a r t h e f o o b a r m a n
                l
                            r


    count = 3   res[ ]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                l
                                  r


    count = 3   res[6, ]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                l
                                  r


    count = 4   res[6, ]    curSeen[bar: 1, foo: 2, the: 1], since curSeen.get(cur) > seen.get(cur)
    b a r f o o f o o b a r t h e f o o b a r m a n
                l
                                        r


    count = 3   res[6, ]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                      l
                                        r


    count = 3   res[6, 9]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                      l
                                        r


    count = 4   res[6, 9]    curSeen[bar: 2, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                      l
                                              r


    count = 3   res[6, 9]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                            l
                                              r


    count = 3   res[6, 9, 12]    curSeen[bar: 1, foo: 1, the: 1]
    b a r f o o f o o b a r t h e f o o b a r m a n
                            l
                                              r
*/
