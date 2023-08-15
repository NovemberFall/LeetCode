package Trie._212_WordSearch_II;

import java.util.ArrayList;
import java.util.List;

class WordSearch_II {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, board, root, i, j);
            }
        }
        return res;
    }

    private void dfs(List<String> res, char[][] board, TrieNode cur, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return;
        }
        if (cur.children[board[i][j] - 'a'] == null) {
            return;
        }

        cur = cur.children[board[i][j] - 'a'];

        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }

        char tmp = board[i][j];
        board[i][j] = '*';
        dfs(res, board, cur, i + 1, j);
        dfs(res, board, cur, i, j + 1);
        dfs(res, board, cur, i - 1, j);
        dfs(res, board, cur, i, j - 1);
        board[i][j] = tmp;
    }
}
