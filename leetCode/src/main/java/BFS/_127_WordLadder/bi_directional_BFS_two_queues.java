package BFS._127_WordLadder;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class bi_directional_BFS_two_queues {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        dict.remove(beginWord);
        dict.remove(endWord);

        Queue<String> forwardQueue = new ArrayDeque<>();
        Queue<String> backwardQueue = new ArrayDeque<>();

        forwardQueue.offer(beginWord);
        backwardQueue.offer(endWord);

        int step = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            if (forwardQueue.size() > backwardQueue.size()) {
                Queue<String> temp = forwardQueue;
                forwardQueue = backwardQueue;
                backwardQueue = temp;
            }
            step++;
            int size = forwardQueue.size();
            for (int i = 0; i < size; i++) {
                String word = forwardQueue.poll();
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char backup = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == backup) continue;

                        wordChars[j] = c;
                        String mutation = new String(wordChars);
                        if (backwardQueue.contains(mutation)) {
                            return step;
                        }
                        if (dict.contains(mutation)) {
                            forwardQueue.offer(mutation);
                            dict.remove(mutation);
                        }
                    }
                    wordChars[j] = backup;
                }
            }
        }
        return 0;
    }
}
