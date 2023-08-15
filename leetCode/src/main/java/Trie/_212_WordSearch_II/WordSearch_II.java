package Trie._212_WordSearch_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearch_II {
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        TrieNode(char c) {
            val = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, new StringBuilder(), i, j, visited, board, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(List<String> res, StringBuilder sb, int i, int j, boolean[][] visited, char[][] board, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        if (!trie.startWith(sb.toString())) {
            return;
        }

        if (trie.search(sb.toString()) && !res.contains(sb.toString())) {
            res.add(sb.toString());
            return;
        }

        visited[i][j] = true;
        sb.append(board[i][j]);
        dfs(res, new StringBuilder(), i + 1, j, visited, board, trie);
        dfs(res, new StringBuilder(), i, j + 1, visited, board, trie);
        dfs(res, new StringBuilder(), i - 1, j, visited, board, trie);
        dfs(res, new StringBuilder(), i, j - 1, visited, board, trie);
        sb.setLength(sb.length() - 1);
        visited[i][j] = false;
    }
}
