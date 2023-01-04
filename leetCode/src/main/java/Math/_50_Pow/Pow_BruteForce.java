package Math._50_Pow;

class Pow_BruteForce {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {
        Pow_BruteForce pow_bruteForce = new Pow_BruteForce();
        double res = pow_bruteForce.myPow(2.1, 3);
        System.out.println(res); // 9.2610

        res = pow_bruteForce.myPow(2.0, -2);
        System.out.println(res); // 0.25
    }
}
