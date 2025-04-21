package dp;

public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacci(45));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
