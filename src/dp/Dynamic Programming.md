# Dynamic Programming
An optimization technique that breaks down a problem into smaller subproblems, solves each subproblem only once, and stores the result to avoid redundant computations.
I other words, DP is an algorithmic technique that relies on **optimal substructure** and **overlapping subproblems** to efficiently solve problems.
## Key Concepts of Dynamic Programming
### Optimal Substructure
- A problem exhibits optimal substructure if its optimal solution can be constructed from the optimal solutions of its subproblems.
- Example: Fibonacci Sequence
  $$
  F(n) = F(n - 1) + F(n - 2)
  $$
- If we know `F(n-1)` and `F(n-2)`, we can efficiently compute `F(n)`.
### Overlapping Subproblems
- A problem has overlapping subproblems if the same smaller problems are solved multiple times.
- Example: Fibonacci Sequence
    - Computing `F(5)` requires `F(3)` and `F(2)`, but `F(3)` is also needed when computing `F(4)`, leading to redundant calculations.
    - **DP avoids this by storing previously computed results.**
## DP Approaches: Memoization vs Tabulation
Dynamic programming can be implemented in two main ways:
- Top-Down (Memoization)
    - Solves a large problem by recursively solving smaller subproblems and caching results
    - Recursion + `dp` array (Memoization)
- Bottom-Up (Tabulation)
    - Solves all smaller subproblems first, then builds up to the final solution
    - Iteration + `dp` array (Tabulation)
## DP Example: Fibonacci Sequence
### Naive recursion (Inefficient)
Problem: Exponential time complexity $O(2^n)$:
```Java
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibonacci(10) = " + fibonacci(45));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```
### Top-Down Approach (Memoization)
- Uses recursion with memoization (caching).
- Easy to implement, intuitive for recursive problems.
- More Memory usage, potential stack overflow.
- Time Complexity: $O(n)$
```Java
public class FibonacciWithMemoization {
    private static int[] memo;

    public static void main(String[] args) {
        int n = 45;
        memo = new int[n + 1];

        System.out.println("fibonacci(10) = " + fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] != 0)
            return memo[n];

        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}

```
### Bottom-Up Approach (Tabulation)
- Uses iteration instead of recursion
- Faster (no recursion overhead), avoids stack overflow.
- Harder to implement for some problems.
- Time Complexity: $O(n)$
```Java
public class FibonacciWithTabulation {
    public static void main(String[] args) {
        System.out.println("fibonacci(45) = " + fibonacci(45));
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
```