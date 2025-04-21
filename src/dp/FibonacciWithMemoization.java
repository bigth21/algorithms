package dp;

public class FibonacciWithMemoization {
    private static int[] memo;

    public static void main(String[] args) {
        int n = 45;
        memo = new int[n + 1];

        long startTime = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacci(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] != 0)
            return memo[n];

        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
