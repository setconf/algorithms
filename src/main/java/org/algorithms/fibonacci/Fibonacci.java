package org.algorithms.fibonacci;

import java.util.stream.Stream;

/*
 * In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * That is,
 *      F 0 = 0 , F 1 = 1 ,
 * and
 *      F n = F n − 1 + F n − 2
 * for n > 1.
 * The sequence starts: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci number</a>
 * */
public class Fibonacci {

    public Stream<Integer> firstNFibonacciNumbers(int amount) {
        int[] fibs = {1, 0};
        if (amount == 0) return Stream.of(0);
        return Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        }).limit(amount);
    }
}
