package dp;

public class BruteForce implements Fibonacci {
    @Override
    public int calculate(int n) {
        if (n == 0 || n == 1)
            return n;
        return calculate(n - 1) + calculate(n - 2);
    }
}
