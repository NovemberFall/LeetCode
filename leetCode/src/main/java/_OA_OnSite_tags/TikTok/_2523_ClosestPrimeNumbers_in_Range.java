package _OA_OnSite_tags.TikTok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _2523_ClosestPrimeNumbers_in_Range {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        generatePrime(isPrime);
        List<Integer> primes = new ArrayList<>();
        for (int p = left; p <= right; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
        if (primes.size() <= 1) {
            return new int[]{-1, -1};
        }
        int mn = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;
        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i + 1) - primes.get(i) == mn) {
                if (num1 > primes.get(i)) {
                    num1 = primes.get(i);
                    num2 = primes.get(i + 1);
                }
            }
            if (primes.get(i + 1) - primes.get(i) < mn) {
                num1 = primes.get(i);
                num2 = primes.get(i + 1);
                mn = primes.get(i + 1) - primes.get(i);
            }
        }
        return new int[]{num1, num2};
    }

    private void generatePrime(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int n = isPrime.length;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
