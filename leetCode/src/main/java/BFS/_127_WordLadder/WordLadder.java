package BFS._127_WordLadder;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (dict.isEmpty() || !dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        int level = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (curWord.equals(endWord)) {
                    return level;
                }
                char[] chars = curWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (dict.contains(word)) {
                            queue.offer(word);
                            dict.remove(word);
                        }
                    }
                }
                level++;
            }
        }
    }
}
