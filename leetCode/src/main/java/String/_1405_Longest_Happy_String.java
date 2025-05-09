package String;

import java.util.PriorityQueue;

class _1405_Longest_Happy_String {
    class Pair {
        char character;
        int count;
        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        if (a > 0) {
            maxHeap.add(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.add(new Pair('b', b));
        }
        if (c > 0) {
            maxHeap.add(new Pair('c', c));
        }

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            int count = p.count;
            char chr = p.character;
            // If three consecutive characters exists, pick the second most frequent character.
            if (res.length() >= 2 && res.charAt(res.length() - 1) == p.character &&
                    res.charAt(res.length() - 2) == p.character) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                Pair secondFreq = maxHeap.poll();
                res.append(secondFreq.character);
                if (secondFreq.count - 1 > 0) {
                    maxHeap.add(new Pair(secondFreq.character, secondFreq.count - 1));
                }
            } else {
                count--;
                res.append(chr);
            }

            // If count is greater than zero, add it to priority queue.
            if (count > 0) {
                maxHeap.add(new Pair(chr, count));
            }
        }
        return res.toString();
    }
}
