package SlideWindow._438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagramsInAString_slidingWindow {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        Map<Character, Integer> map = buildMap(p);
        int count = map.size();
        int slow = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }

                while (count == 0) {
                    char slowChar = s.charAt(slow);
                    if (map.containsKey(slowChar)) {
                        map.put(slowChar, map.get(slowChar) + 1);
                        if (map.get(slowChar) > 0) {
                            count++;
                        }
                    }
                    if (fast - slow + 1 == p.length()) {
                        res.add(slow);
                    }
                    slow++;
                }
            }
        }
        return res;
    }

    private Map<Character, Integer> buildMap(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
