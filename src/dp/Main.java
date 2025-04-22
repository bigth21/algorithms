package dp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fibonacci> fibonacciList = List.of(new BruteForce(), new Tabulation(), new Memoization());
        for (Fibonacci fibonacci : fibonacciList) {
            long startTime = System.currentTimeMillis();

            System.out.println(fibonacci.getClass().getSimpleName() + ".execute() = " + fibonacci.calculate(45));

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        }
    }
}
