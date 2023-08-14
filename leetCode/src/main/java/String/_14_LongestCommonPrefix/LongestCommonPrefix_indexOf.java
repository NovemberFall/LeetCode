package String._14_LongestCommonPrefix;

class LongestCommonPrefix_indexOf {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
//                System.out.println(pre);
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_indexOf lcp = new LongestCommonPrefix_indexOf();
        String[] strs = new String[]{"flower", "flight"};
        String res = lcp.longestCommonPrefix(strs);
        System.out.println("**************************************");
        System.out.println(res);
    }
}
