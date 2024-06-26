package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _472_ConcatenatedWords_Trie {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        TrieNode root = buildTrie(words); // construct Trie tree

        for (String word : words) { // test word is a concatenated word or not
            if (word.length() == 0) {
                continue;
            }
            if (dfs(root, word, 0)) {
                System.out.println(word);
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(TrieNode root, String word, int index) {
        TrieNode cur = root;

        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }

            cur = cur.children[c - 'a'];
            if (cur.word != null && !cur.word.equals(word)) {
                if (dfs(root, word, i + 1)) {
                    return true;
                }
            }
        }
        return index != 0 && cur.word != null;
    }


    public TrieNode buildTrie(String[] words) {
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

    public static void main(String[] args) {
        _472_ConcatenatedWords_Trie concatenatedWords = new _472_ConcatenatedWords_Trie();
        String[] words = new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        List<String> res = concatenatedWords.findAllConcatenatedWordsInADict(words);
        System.out.println(res);
    }
}
