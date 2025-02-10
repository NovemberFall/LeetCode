package BFS._126_WordLadder_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordLadder_II_bi_directional_BFS {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);
        dict.remove(endWord);
        Set<String> forwardQueue = new HashSet<>();
        Set<String> backwardQueue = new HashSet<>();
        forwardQueue.add(beginWord);
        backwardQueue.add(endWord);
        boolean exist = false;
        Map<String, List<String>> mutationMap = new HashMap<>();
        boolean isBackward = true;

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            if (exist) {
                break;
            }
            if (forwardQueue.size() > backwardQueue.size()) {
                Set<String> temp = forwardQueue;
                forwardQueue = backwardQueue;
                backwardQueue = temp;
                isBackward = !isBackward;
            }
            Set<String> forwardMutation = new HashSet<>();
            for (String word : forwardQueue) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char backup = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == backup) {
                            continue;
                        }
                        wordChars[i] = c;
                        String mutation = new String(wordChars);
                        String parent = isBackward ? word : mutation;
                        String child = isBackward ? mutation : word;
                        if (backwardQueue.contains(mutation)) {
                            exist = true;
                            mutationMap.putIfAbsent(parent, new ArrayList<>());
                            mutationMap.get(parent).add(child);
                        }
                        if (dict.contains(mutation)) {
                            mutationMap.putIfAbsent(parent, new ArrayList<>());
                            mutationMap.get(parent).add(child);
                            forwardMutation.add(mutation);
                        }
                    }
                    wordChars[i] = backup;
                }
            }
            dict.removeAll(forwardMutation);
            forwardQueue = forwardMutation;
        }
        if (!exist) {
            return res;
        }

        dfs(beginWord, endWord, mutationMap, new ArrayList<>(Arrays.asList(beginWord)), res);
        return res;
    }

    private void dfs(String curWord, String endWord, Map<String, List<String>> mutationMap, List<String> path,
                     List<List<String>> res) {

        if (curWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String word : mutationMap.getOrDefault(curWord, Collections.emptyList())) {
            path.add(word);
            dfs(word, endWord, mutationMap, path, res);
            path.remove(path.size() - 1);
        }

    }
}
