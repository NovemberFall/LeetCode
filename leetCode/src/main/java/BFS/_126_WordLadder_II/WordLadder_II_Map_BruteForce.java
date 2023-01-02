package BFS._126_WordLadder_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordLadder_II_Map_BruteForce {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }

        Map<String, List<List<String>>> layer = new HashMap<>();
        layer.put(beginWord, new ArrayList<>());
        layer.get(beginWord).add(new ArrayList<>(Arrays.asList(beginWord)));

        while (!layer.isEmpty()) {
            Map<String, List<List<String>>> newLayer = new HashMap<>();
            for (String word : layer.keySet()) {
                if (word.equals(endWord)) {
                    return layer.get(word);
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
                        if (!dict.contains(newWord)) {
                            continue;
                        }
                        if (!newLayer.containsKey(newWord)) {
                            newLayer.put(newWord, new ArrayList<>());
                        }
                        for (List<String> list : layer.get(word)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(newWord);
                            newLayer.get(newWord).add(newList);
                        }
                    }
                }
            }
            layer = newLayer;
            for (String str : newLayer.keySet()) {
                dict.remove(str);
            }
        }
        return new ArrayList<>();
    }
}
