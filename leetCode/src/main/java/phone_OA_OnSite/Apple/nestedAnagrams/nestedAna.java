package phone_OA_OnSite.Apple.nestedAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class nestedAna {
    public static void main(String[] args) {
        boolean test1 = nestedAnagrams("bored cat", "act robed");
        System.out.println(test1);

        boolean test2 = nestedAnagrams("ab ba", "aa bb");
        System.out.println(test2);
    }


    //Time -  NMlogM
    // N - Math.max(count of words in string1, count of words in string2)
    // M - Math.max(word with largest number of letters in any String)
    public static boolean nestedAnagrams(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }

        String[] str1Arr = string1.split(" ");

        Map<String, Integer> store = new HashMap<>();

        for (String word : str1Arr) {

            char[] charArray = word.toCharArray();

            Arrays.sort(charArray); // nlogn

            store.put(String.valueOf(charArray), 0);

        }

        String[] string2Array = string2.split(" ");

        for (String word : string2Array) {

            char[] charArray = word.toCharArray();

            Arrays.sort(charArray); // nlogn

            if (!store.containsKey(String.valueOf(charArray))) { //n
                return false;
            }
        }
        return true;
    }

    //Time -  NM
    // N - Math.max(count of words in string1, count of words in string2)
    // M - Math.max(word with largest number of letters in any String)
    public static boolean nestedAnagrams2(String string1, String string2) {

        if (string1.length() != string2.length()) return false;

        String[] string1Array = string1.split(" ");

        Map<String, Integer> store = new HashMap<>();

        int[] count = new int[26];

        for (String word : string1Array) {
            String key = helper(count, word);
            store.put(key, 0);
        }

        String[] string2Array = string2.split(" ");

        for (String word : string2Array) {

            String key = helper(count, word);

            if (!store.containsKey(key)) { //n
                return false;
            }

        }
        return true;
    }

    // helper function
    public static String helper(int[] count, String word) {

        Arrays.fill(count, 0);

        for (char c : word.toCharArray()) count[c - 'a']++;

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append('*');
            sb.append(count[i]);
        }

        String key = sb.toString();

        return key;

    }
}
