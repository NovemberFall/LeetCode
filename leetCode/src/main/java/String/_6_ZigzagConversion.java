package String;

class _6_ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int idx = 0;
        while (idx < len) {
            for (int i = 0; i < numRows && idx < len; i++) {
                sb[i].append(c[idx++]);
            }
            for (int i = numRows - 2; i >= 1 && idx < len; i--) {
                sb[i].append(c[idx++]);
            }
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        _6_ZigzagConversion zzc = new _6_ZigzagConversion();
        String s = "PAYPALISHIRING";
        String ans =  zzc.convert(s, 3);
        System.out.println(ans);
    }
}
