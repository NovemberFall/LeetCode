package String.API.IndexOf;

class _14_LongestCommonPrefix_test {
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
        _14_LongestCommonPrefix_test longestCommonPrefixTest = new _14_LongestCommonPrefix_test();
        String str1 = "flower", str2 = "flight";
        System.out.println(str1 + " : " + str2.indexOf(str1));
        str1 = str1.substring(0, str1.length() - 1);
        System.out.println(str1 + " : " + str2.indexOf(str1));
        str1 = str1.substring(0, str1.length() - 1);
        System.out.println(str1 + " : " + str2.indexOf(str1));
        str1 = str1.substring(0, str1.length() - 1);
        System.out.println(str1 + " : " + str2.indexOf(str1));
        str1 = str1.substring(0, str1.length() - 1);
        System.out.println(str1 + " : " + str2.indexOf(str1));
    }
}
