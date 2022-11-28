package String._38_CountAndSay;

public class CountAndSay_iterator {
    public static String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 1, count = 1; j <= prev.length(); j++) {
                if (j == prev.length() || prev.charAt(j - 1) != prev.charAt(j)) {
                    cur.append(count);
                    cur.append(prev.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            prev = cur.toString();
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 4;
        String str = countAndSay(n);
        System.out.println(str);
    }
}
