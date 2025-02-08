package BFS._127_WordLadder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class bi_directional_BFS_two_sets {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        dict.remove(beginWord);
        dict.remove(endWord);

        Set<String> forwardQueue = new HashSet<>();
        Set<String> backwardQueue = new HashSet<>();

        forwardQueue.add(beginWord);
        backwardQueue.add(endWord);

        int step = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            if (forwardQueue.size() > backwardQueue.size()) {
                Set<String> temp = forwardQueue;
                forwardQueue = backwardQueue;
                backwardQueue = temp;
            }
            step++;
            Set<String> forwardMutation = new HashSet<>();
            for (String word : forwardQueue) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char backup = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == backup) continue;

                        wordChars[i] = c;
                        String mutation = new String(wordChars);
                        if (backwardQueue.contains(mutation)) {
                            return step;
                        }
                        if (dict.contains(mutation)) {
                            forwardMutation.add(mutation);
                            dict.remove(mutation);
                        }
                    }
                    wordChars[i] = backup;
                }
            }
            forwardQueue = forwardMutation;
        }
        return 0;
    }
}
