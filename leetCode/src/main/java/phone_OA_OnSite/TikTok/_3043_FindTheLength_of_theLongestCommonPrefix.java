package phone_OA_OnSite.TikTok;

class _3043_FindTheLength_of_theLongestCommonPrefix {
    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[10];
        }

        public void insert(int num) {
            TrieNode node = root;
            String str = Integer.toString(num);
            for (int i = 0; i < str.length(); i++) {
                if (node.children[str.charAt(i) - '0'] == null) {
                    node.children[str.charAt(i) - '0'] = new TrieNode();
                }
                node = node.children[str.charAt(i) - '0'];
            }
        }

        public int check(int num) {
            TrieNode node = root;
            String str = Integer.toString(num);
            int len = 0;
            for (char c : str.toCharArray()) {
                if (node.children[c - '0'] != null) {
                    len++;
                } else {
                    break;
                }
                node = node.children[c - '0'];
            }
            return len;
        }
    }

    private TrieNode root = new TrieNode();


    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode trie = new TrieNode();
        int res = 0;
        for (int num : arr1) {
            trie.insert(num);
        }
        for (int num : arr2) {
            res = Math.max(res, trie.check(num));
        }
        return res;
    }
}
