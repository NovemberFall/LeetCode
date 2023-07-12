package String._383_RansomNote;

import java.util.HashMap;
import java.util.Map;

class ransomNote_map {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length(), len2 = magazine.length();
        if (len1 > len2) return false;

        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magaMap = new HashMap<>();

        for (Character c : ransomNote.toCharArray()) {
            ransomMap.put(c, ransomMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : magazine.toCharArray()) {
            magaMap.put(c, magaMap.getOrDefault(c, 0) + 1);
        }

        for (Character key : ransomMap.keySet()) {
            if (!magaMap.containsKey(key) || magaMap.get(key) < ransomMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
