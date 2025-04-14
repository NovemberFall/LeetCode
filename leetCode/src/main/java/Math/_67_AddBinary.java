package Math;

class _67_AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            res.append("1");
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        _67_AddBinary addBinary = new _67_AddBinary();
        String res = addBinary.addBinary("1010", "1011");
        System.out.println(res); // "10101"
    }
}
