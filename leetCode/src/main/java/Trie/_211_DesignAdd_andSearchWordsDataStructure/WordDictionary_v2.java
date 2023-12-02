package Trie._211_DesignAdd_andSearchWordsDataStructure;


class WordDictionary_v2 {
    TrieNode root;
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    public WordDictionary_v2() {
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
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode tn : node.children) {
                if (tn != null && dfs(word, index + 1, tn)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode nextNode = node.children[c - 'a'];
            return nextNode != null && dfs(word, index + 1, nextNode);
        }
    }
}
/**
 Input
 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],              ["bad"],   ["dad"],  ["mad"],  ["pad"], ["bad"], [".ad"], ["b.."]]
 Output
 [null,             null,     null,     null,     false,   true,    true,    true]

 Explanation
 WordDictionary wordDictionary = new WordDictionary();
 wordDictionary.addWord("bad");
 wordDictionary.addWord("dad");
 wordDictionary.addWord("mad");
 wordDictionary.search("pad"); // return False
 wordDictionary.search("bad"); // return True
 wordDictionary.search(".ad"); // return True
 wordDictionary.search("b.."); // return True
 */
