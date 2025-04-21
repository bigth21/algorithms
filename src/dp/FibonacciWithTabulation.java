package dp;

public class FibonacciWithTabulation {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("fibonacci(45) = " + fibonacci(45));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
