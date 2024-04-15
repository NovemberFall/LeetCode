package Math._202_HappyNumber;

class happyNumber_Floyd {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int sumOfSquares(int n) {
        int sum = 0, digit = 0;
        while (n > 0) {
            digit = n % 10;
            digit = digit * digit;
            sum += digit;
            n /= 10;
        }
        return sum;
    }
}
