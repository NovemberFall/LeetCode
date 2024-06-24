package phone_OA_OnSite.TikTok;

import java.util.HashMap;
import java.util.Map;

class _443_StringCompression {
    public int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                chars[i++] = c;
            } else {
                chars[i++] = c;
                String digits = String.valueOf(map.get(c)); // maybe digits = 8, or 11
                for (char digit : digits.toCharArray()) {
                    chars[i++] = digit;
                }
            }
        }
        System.out.println(new String(chars));

        return i;
    }

    public static void main(String[] args) {
        _443_StringCompression stringCompression = new _443_StringCompression();
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int res = stringCompression.compress(chars);
        System.out.println(res);
    }
}
