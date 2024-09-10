package Math;

import java.util.Arrays;

class _204_Count_Primes {
    public int countPrimes(int n) {
        // Step 1: Initialize the isPrime array
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // step 2: Iterate from 2 to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Count the remaining prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean checkPrime(int n) {
        // Step 1: Initialize the isPrime array
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // step 2: Iterate from 2 to sqrt(n)
        for (int i = 2; i * i < n + 1; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n + 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[n];
    }

    public static void main(String[] args) {
        _204_Count_Primes countPrimes = new _204_Count_Primes();
        boolean ans = countPrimes.checkPrime(44);
        System.out.println(ans);
    }
}
