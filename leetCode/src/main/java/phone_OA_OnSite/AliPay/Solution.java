package phone_OA_OnSite.AliPay;

import java.util.HashMap;
import java.util.Map;

/*
 * INPUT: String str1, String str2, String str3, Map<Character, Integer> map
 * STRING: [A-Z],
 * MAP: KEY: [A-Z], VALUE: [0-9], 1:1 mapping
 *
 * map = {A:1, B:2, C:3, ...}
 * s1: "ABC" =>   123
 * s2: "GBC" => + 723
 * ======================
 * s3: "DEF" =>   846
 *
 * OUTPUT: BOOLEAN(TRUE ==, FALSE !=), IllegalArgumentException
 *
 * TESTCASES:
 * 1. check hashmap
 * 2. like example, ==
 */
class Solution {
    public boolean check(String s1, String s2, String s3, Map<Character, Integer> map) {
        buildMap(map);
        StringBuilder sb1 = new StringBuilder();
        for (char c : s1.toCharArray()) {
            int num = map.get(c);
            if (num < 1 || num > 26) {
                throw new IllegalArgumentException("The character is not A ~ Z");
            }
            sb1.append(num);
        }
        int str1 = Integer.valueOf(sb1.toString());
        System.out.println(str1);

        StringBuilder sb2 = new StringBuilder();
        for (char c : s2.toCharArray()) {
            int num = map.get(c);
            if (num < 1 || num > 26) {
                throw new IllegalArgumentException("The character is not A ~ Z");
            }
            sb2.append(num);
        }
        int str2 = Integer.valueOf(sb2.toString());
        System.out.println(str2);

        StringBuilder sb3 = new StringBuilder();
        for (char c : s3.toCharArray()) {
            int num = map.get(c);
            if (num < 1 || num > 26) {
                throw new IllegalArgumentException("The character is not A ~ Z");
            }
            sb3.append(num);
        }
        int str3 = Integer.valueOf(sb3.toString());
        System.out.println(str3);

        int sum = str1 + str2;

        return sum == str3;
    }

    private void buildMap(Map<Character, Integer> map) {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, ++i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ABC";
        String s2 = "GBC";
        String s3 = "DEF";
        Map<Character, Integer> map = new HashMap<>();
        solution.check(s1, s2, s3, map);
    }
}

// 101 ~ 132
// A - Z :   1 - 26
