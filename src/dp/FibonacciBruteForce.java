package dp;

public class FibonacciBruteForce implements Fibonacci {
    @Override
    public int execute(int n) {
        if (n == 0 || n == 1)
            return n;
        return execute(n - 1) + execute(n - 2);
    }
}
