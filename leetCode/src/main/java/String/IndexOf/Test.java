package String.IndexOf;

public class Test {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                System.out.println(pre);
            }
        }
        return pre;
    }

    public static void main(String[] args) {
//        String str = "flower";
//        String str1 = "flow";
//        String str2 = "flight";
//        int idx = str.indexOf(str1);
//        System.out.println(idx);
//        int idx = str.indexOf(str2);
//        System.out.println(idx);
//        String[] strs = new String[]{"flower", "flight"};
        String[] strs = new String[]{"dog","racecar","car"};
        longestCommonPrefix(strs);
    }
}
