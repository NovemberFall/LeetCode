package Trie;

class _208_Implement_Trie {

    private TrieNode root;

    static class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char c) {
            children = new TrieNode[26];
            isWord = false;
            val = c;
        }
    }

    public _208_Implement_Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        _208_Implement_Trie trie = new _208_Implement_Trie();
        trie.insert("apple");
        boolean res = trie.search("apple");
        System.out.println(res);
        res = trie.search("app");
        System.out.println(res);
        res = trie.startWith("app");
        System.out.println(res);
        trie.insert("app");
        res = trie.search("app");
        System.out.println(res);
    }
}
