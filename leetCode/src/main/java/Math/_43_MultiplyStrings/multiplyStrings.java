package Math._43_MultiplyStrings;

class multiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] += mul;
            }
        }

        for (int i = res.length - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num);
        }

        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        multiplyStrings multiplyStrings = new multiplyStrings();
//        String res = "";
//        res = multiply("123", "456");
//        System.out.println(res);

        String res2 = multiplyStrings.multiply("2", "3");
//        System.out.println(res2);
    }
}
