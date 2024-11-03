package _OA_OnSite_tags.TikTok._1062_LongestRepeatingSubstring;

class TrieTree {
    static class TrieNode {
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }
    public int longestRepeatingSubstring(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int res = 0;
        TrieNode root = new TrieNode();
        for (int i = 0; i < len; i++) {
            TrieNode cur = root;
            for (int j = i; j < len; j++) {
                if (cur.next[arr[j] - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    cur.next[arr[j] - 'a'] = newNode;
                    cur = newNode;
                } else {
                    res = Math.max(res, j - i + 1);
                    cur = cur.next[arr[j] - 'a'];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrieTree tt = new TrieTree();
        int res = tt.longestRepeatingSubstring("abbcd");
        System.out.println(res);
    }
}
