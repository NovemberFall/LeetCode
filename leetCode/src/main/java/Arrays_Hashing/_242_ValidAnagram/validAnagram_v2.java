package Arrays_Hashing._242_ValidAnagram;

class validAnagram_v2 {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for (Character c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (Character c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
