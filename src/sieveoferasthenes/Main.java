package sieveoferasthenes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PrimeNumbers> primeNumbers = List.of(new BruteForce(), new SieveOfEratosthenes());
        for (PrimeNumbers primeNumber : primeNumbers) {
            long startTime = System.currentTimeMillis();

            int n = 50;
            List<Integer> primes = primeNumber.findPrimes(n);
            System.out.println("primes = " + primes);

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        }
    }
}
