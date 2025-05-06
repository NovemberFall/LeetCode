package String._28_KMP_Find_IndexOf_FirstOccurrenceInString;

public class strStr_two_pointer {
    public int subStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "cde";
        System.out.println(new strStr_two_pointer().subStr(s1, s2));
    }
}
