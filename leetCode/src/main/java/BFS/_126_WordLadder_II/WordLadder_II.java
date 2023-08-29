package BFS._126_WordLadder_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class WordLadder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);

        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, steps, from);

        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }
        return res;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps,
                        Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] chars = curWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = String.valueOf(chars);
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(curWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(curWord);
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    chars[j] = old;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }

    private void dfs(Map<String, Set<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String previous : from.get(cur)) {
            path.addFirst(previous);
            dfs(from, path, beginWord, previous, res);
            path.removeFirst();
        }
    }
}
