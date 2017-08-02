package dynamicprogramming.factorial;

/**
 * Top Down approach
 */
public class Factorial {

    // time complexity = O(n), space = O(n)
    //if you did this recursively without memoization time = O(2^n)
    public static int fibonacci(int n) {
        return fibonacci(n, new int[n + 1]);
    }

    public static int fibonacci(int n, int[] table) {
        if (n == 0 || n == 1) return n;

        if (table[n] == 0) {
            table[n] = fibonacci(n - 1, table) + fibonacci(n - 2, table);
        }
        return table[n];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int trials = 10; // Run code multiple times to compute average time.

        for (int j = 0; j < trials; j++) { // Run this 10 times to compute
            System.out.println(fibonacci(j));
        }

    }
}
