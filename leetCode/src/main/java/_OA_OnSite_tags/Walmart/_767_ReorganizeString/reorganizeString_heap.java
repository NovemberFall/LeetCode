package _OA_OnSite_tags.Walmart._767_ReorganizeString;

import java.util.PriorityQueue;

class reorganizeString_heap {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
//            if (freq[c - 'a'] > ((s.length() + 1) / 2)) {
//                return "";
//            }
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // add char counts to priority queue
            }
        }

        int[] prev = new int[]{-1, 0};
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            if (prev[1] > 0) {
                maxHeap.offer(prev); // add back last used character
            }
            sb.append((char) (cur[0] + 'a'));
            cur[1]--; // decrease count of current char since it's used
            prev = cur; // set this character as previous used
        }

        if (maxHeap.isEmpty() && prev[1] > 0) {
            return ""; // if we left with anything return ""
        }
        return sb.toString();
    }
}

