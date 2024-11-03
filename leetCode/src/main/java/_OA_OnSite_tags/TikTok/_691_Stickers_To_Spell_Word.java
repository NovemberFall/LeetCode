package _OA_OnSite_tags.TikTok;

import java.util.HashMap;
import java.util.Map;

class _691_Stickers_To_Spell_Word {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>(); // key = subseq of target | val = min num of stickers
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        dp.put("", 0);
        return helper(dp, mp, target);
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int ans = Integer.MAX_VALUE, numOfStickers = mp.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }

        // try every sticker
        for (int i = 0; i < numOfStickers; i++) {
            // optimization
            if (mp[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            // apply a sticker on every character a-z
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                        sb.append((char) (j + 'a')); // sb records the remainding chars of target
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }

    public static void main(String[] args) {
        _691_Stickers_To_Spell_Word stickersToSpellWord = new _691_Stickers_To_Spell_Word();
        String[] stickers = new String[]{"with", "example", "science"};
        String target = "thehat";
        int res = stickersToSpellWord.minStickers(stickers, target);
        System.out.println(res);
    }
}
