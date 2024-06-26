package Trie._211_DesignAdd_andSearchWordsDataStructure;

class WordDictionary {
    private TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode cur, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && find(word, cur.children[i], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode nextNode = cur.children[c - 'a'];
            return nextNode != null && find(word, cur.children[c - 'a'], index + 1);
        }
    }
}




