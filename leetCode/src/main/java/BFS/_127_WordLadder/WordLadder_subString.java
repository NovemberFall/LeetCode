package BFS._127_WordLadder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder_subString {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (dict.isEmpty() || !dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (curWord.equals(endWord)) {
                    return level;
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < curWord.length(); j++) {
                        String newWord =
                                curWord.substring(0, j) + c + curWord.substring(j + 1);
                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder_subString wordLadder = new WordLadder_subString();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit", endWord = "cog";
        int res = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
