package String._383_RansomNote;

class ransomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (Character c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (Character c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
