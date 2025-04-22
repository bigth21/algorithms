package dp;

public class DpMemoization implements Fibonacci {
    @Override
    public int calculate(int n) {
        int[] memo = new int[n + 1];
        return dfs(memo, n);
    }

    private int dfs(int[] memo, int n) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] != 0)
            return memo[n];

        return memo[n] = dfs(memo, n - 1) + dfs(memo, n - 2);
    }
}
