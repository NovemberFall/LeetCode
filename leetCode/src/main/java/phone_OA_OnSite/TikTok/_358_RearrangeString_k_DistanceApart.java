package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class _358_RearrangeString_k_DistanceApart {
    public String rearrangeString(String s, int k) {
        if (k == 0 || s.length() < k) {
            return s;
        }

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                maxHeap.offer(new int[]{i, map[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            List<Integer> charIndexes = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int[] cur = maxHeap.poll();
                char c = (char) (cur[0] + 'a');
                sb.append(c);
                charIndexes.add(cur[0]);

                if (maxHeap.size() == 0) {
                    if (i != k - 1 && sb.length() != s.length()) {
                        return "";
                    }
                    break;
                }
            }

            for (int index : charIndexes) {
                if (--map[index] > 0) {
                    maxHeap.offer(new int[]{index, map[index]});
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _358_RearrangeString_k_DistanceApart rearrangeStringKDistanceApart = new _358_RearrangeString_k_DistanceApart();
        String s = "aabbcc";
        int k = 3;
        rearrangeStringKDistanceApart.rearrangeString(s, k);
    }
}
