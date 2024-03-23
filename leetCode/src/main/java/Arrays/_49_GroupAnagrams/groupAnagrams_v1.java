package Arrays._49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class groupAnagrams_v1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmpKey = str.toCharArray();
            Arrays.sort(tmpKey);
            String key = String.valueOf(tmpKey);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        for (List<String> list : map.values()) {
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public static void main(String[] args) {
        groupAnagrams_v1 ga = new groupAnagrams_v1();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = ga.groupAnagrams(strs);
        System.out.println(res);
    }
}
