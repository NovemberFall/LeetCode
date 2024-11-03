package _OA_OnSite_tags.Apple.nestedAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class nestedAnagrams {

    public static boolean nestedAnagrams(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }

        String[] strArr1 = string1.split(" ");
        Map<String, Integer> freqMap = getFreqMap(strArr1);

        String[] strArr2 = string2.split(" ");

        Map<String, Integer> freqMap2 = getFreqMap(strArr2);

        return freqMap.equals(freqMap2);
    }

    public static Map<String, Integer> getFreqMap(String[] words){
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : words) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String tmp = String.valueOf(charArr);
            Integer val = freqMap.get(tmp);
            if (val == null) {
                freqMap.put(tmp, 1);
            } else {
                freqMap.put(tmp, val + 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        boolean test1 = nestedAnagrams("bored cat", "act robed");
        System.out.println(test1);

        boolean test2 = nestedAnagrams("ab ba", "aa bb");
        System.out.println(test2);

        boolean test3 = nestedAnagrams("bored cat bored", "act robed");
        System.out.println(test3);
    }



//    public static boolean nestedAnagrams(String string1, String string2) {
//
//        if (string1.length() != string2.length()) {
//            return false;
//        }
//
//        String[] strArr1 = string1.split(" ");
//
//        JavaAPI.Set<String> set = new HashSet<>();
//        for (String word : strArr1) {
//            char[] charArr = word.toCharArray();
//            Arrays.sort(charArr);
//            set.add(String.valueOf(charArr));
//        }
//
//        String[] strArr2 = string2.split(" ");
//
//        for (String word : strArr2) {
//            char[] charArr = word.toCharArray();
//            Arrays.sort(charArr);
//            if (!set.contains(String.valueOf(charArr))) {
//                return false;
//            }
//        }
//        return true;
//    }
}
