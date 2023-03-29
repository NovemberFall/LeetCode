package String._58_LengthOfLastWord;

public class lengthOfLastWord_v2 {
    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) return 0;

        int count = 0, end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            // Skip all whitespaces at the end of s.
            end--;
        }
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
            count++;
        }
        return count;
    }
}
