package Math._7_ReverseInteger;

class reverseInteger_NotUsing_64_bits {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int reversed = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            reversed = (reversed * 10) + digit;
        }
        return isNegative ? -reversed : reversed;
    }
}
