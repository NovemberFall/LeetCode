package Math._50_Pow;

class Pow {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / recursion(x, -n);
        }

        return recursion(x, n);
    }

    private double recursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = recursion(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
