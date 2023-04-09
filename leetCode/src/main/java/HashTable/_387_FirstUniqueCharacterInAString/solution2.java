package HashTable._387_FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

class solution2 {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 1) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (freq.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
