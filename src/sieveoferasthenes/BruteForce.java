package sieveoferasthenes;

import java.util.ArrayList;
import java.util.List;

public class BruteForce implements PrimeNumbers {
    @Override
    public List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        return primes;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
