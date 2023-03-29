package String._58_LengthOfLastWord;

import java.util.Arrays;

class lengthOfLastWord_split {
    public int lengthOfLastWord(String s) {
//        s = s.trim();
        String[] words = s.split("\\s+");
        System.out.println(Arrays.toString(words));
        int n = words.length;
        return words[n - 1].length();
    }

    public static void main(String[] args) {
        lengthOfLastWord_split lolw = new lengthOfLastWord_split();
        System.out.println(lolw.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
