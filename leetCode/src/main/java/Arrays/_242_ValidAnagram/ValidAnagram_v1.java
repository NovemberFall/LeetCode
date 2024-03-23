package Arrays._242_ValidAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class ValidAnagram_v1 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> ms = new HashMap<>();
        Map<Character, Integer> mt = new HashMap<>();

        for (Character c : s.toCharArray()) {
            ms.put(c, ms.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            mt.put(c, mt.getOrDefault(c, 0) + 1);
        }

        return Objects.equals(ms, mt);
    }
}
