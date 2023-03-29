package Math;

class _38_CountAndSay {
    public String countAndSay(int n) {
        String prev = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1, count = 1; j <= prev.length(); j++) {
                if (j == prev.length() || prev.charAt(j - 1) != prev.charAt(j)) {
                    // when j reach out prev.length(), which is out of range,
                    // so we just need to check if `j == prev.length()`
                    sb.append(count);
                    sb.append(prev.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            prev = sb.toString();
        }
        return prev;
    }

    public static void main(String[] args) {
        _38_CountAndSay cas = new _38_CountAndSay();
        String res = cas.countAndSay(4);
        System.out.println(res); // 1211
    }
}
