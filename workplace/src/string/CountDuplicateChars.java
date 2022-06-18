package string;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateChars {
    public static void main(String[] args) {
        String input = "JavaJavaEE";

        // create a HashMap
        Map<Character, Integer> countDuplicateMap = new HashMap<>();

        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (countDuplicateMap.containsKey(c)) {
                countDuplicateMap.put(c, countDuplicateMap.get(c) + 1);
            } else {
                countDuplicateMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countDuplicateMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
