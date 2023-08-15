package Trie._212_WordSearch_II;

import java.util.ArrayList;
import java.util.List;

class WordSearch_II_stringBuilder {
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
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int i, int j, boolean[][] visited, char[][] board, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        sb.append(board[i][j]);

        if (!trie.startWith(sb.toString())) {
            sb.setLength(sb.length() - 1);
            return;
        }

        if (trie.search(sb.toString()) && !res.contains(sb.toString())) {
            res.add(sb.toString());
        }

        visited[i][j] = true;
        dfs(res, sb, i + 1, j, visited, board, trie);
        dfs(res, sb, i, j + 1, visited, board, trie);
        dfs(res, sb, i - 1, j, visited, board, trie);
        dfs(res, sb, i, j - 1, visited, board, trie);
        sb.setLength(sb.length() - 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        WordSearch_II_stringBuilder wordSearchIi = new WordSearch_II_stringBuilder();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e', 'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> res = wordSearchIi.findWords(board, words);
        System.out.println(res);
    }
}
