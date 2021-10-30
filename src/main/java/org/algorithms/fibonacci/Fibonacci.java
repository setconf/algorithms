package org.algorithms.fibonacci;

import java.util.stream.Stream;

public class Fibonacci {

    public Stream<Integer> firstNFibonacciNumbers(int amount) {
        int[] fibs = {1, 0};
        return Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        }).limit(amount);
    }
}
