package BFS._126_WordLadder_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder_II_List_BruteForce {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        Queue<List<String>> queue = new ArrayDeque<>();

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);

        while (!queue.isEmpty()) {
            if (!res.isEmpty()) {//if res is not empty, that means it has added shortest pathes
                return res;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> currentList = queue.poll();
                String currentWord = currentList.get(currentList.size() - 1);
                dict.remove(currentWord);
                if (currentWord.equals(endWord)) {
                    res.add(new ArrayList<>(currentList));
                } else {
                    for (int j = 0; j < currentWord.length(); j++) {//逐个修改单词
                        for (char c = 'a'; c <= 'z'; c++) {
                            String newWord =
                                    currentWord.substring(0, j) + c + currentWord.substring(j + 1);
                            if (dict.contains(newWord)) {
                                currentList.add(newWord);
                                queue.offer(new ArrayList<>(currentList)); // deep copy
                                currentList.remove(currentList.size() - 1); // backtracking
                                /*
                                        "abc"
                                     "abd"   "acc"
                                     "acd"   "acd"
                                */
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadder_II_List_BruteForce wordLadder2 = new WordLadder_II_List_BruteForce();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit", endWord = "cog";
        List<List<String>> res = wordLadder2.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
