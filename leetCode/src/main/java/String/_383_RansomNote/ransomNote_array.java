package String._383_RansomNote;

class ransomNote_array {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length(), len2 = magazine.length();
        if (len1 > len2) return false;

        int[] freq = new int[26];
        for (Character c : ransomNote.toCharArray()) {
            freq[c - 'a']++;
        }

        for (Character c : magazine.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i : freq) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}