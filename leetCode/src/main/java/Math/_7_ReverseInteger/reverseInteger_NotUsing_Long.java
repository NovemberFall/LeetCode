package Math._7_ReverseInteger;

class reverseInteger_NotUsing_Long {
    public int reverse(int x) {
        int reversed = 0;
        int digit;

        while (x != 0) {
            digit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 ||
                    reversed == Integer.MAX_VALUE / 10 && digit > 7) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                    reversed == Integer.MIN_VALUE / 10 && digit < -8) {
                return 0;
            }

            reversed = (reversed * 10) + digit;
        }
        return reversed;
    }
}
