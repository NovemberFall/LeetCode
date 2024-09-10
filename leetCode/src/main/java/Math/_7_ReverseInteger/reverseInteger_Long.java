package Math._7_ReverseInteger;

class reverseInteger_Long {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10;
            res += x % 10;
            x /= 10;
        }

        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        reverseInteger_Long reverseIntegerLong = new reverseInteger_Long();
        int num = 1534236469;
        System.out.println(reverseIntegerLong.reverse(num)); // overflow, it returns 0
        num = 456;
        System.out.println(reverseIntegerLong.reverse(num));
        num = -1234;
        System.out.println(reverseIntegerLong.reverse(num));
    }
}
