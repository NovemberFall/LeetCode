package Trie._472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ConcatenatedWords_Trie_dfs {
    TrieNode root = new TrieNode();

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];;
            isEnd = false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, visited, 0)) {
                res.add(word);
            } else {
                insertWord(word);
            }
        }
        return res;
    }



    public boolean dfs(String word, boolean[] visited, int index) {
        TrieNode cur = root;
        if (index == word.length()) {
            return true;
        }
        if (visited[index]) {
            return false;
        }

        visited[index] = true;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
            if (cur.isEnd) {
                if (dfs(word, visited, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void insertWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
}
