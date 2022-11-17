package HashTable;

import java.util.HashMap;
import java.util.Map;

class _13_RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] arr = s.toCharArray();
        int n = arr.length;
        int num = map.get(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (map.get(arr[i + 1]) <= map.get(arr[i])) {
                num += map.get(arr[i]);
            } else {
                num -= map.get(arr[i]);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
