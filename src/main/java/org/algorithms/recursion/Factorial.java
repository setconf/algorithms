package org.algorithms.recursion;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/*
 * In mathematics, the factorial of a non-negative integer n, denoted by n!,
 * is the product of all positive integers less than or equal to n:
 * n ! = n * ( n − 1 ) * ( n − 2 ) * ( n − 3 ) * ... * 3 * 2 * 1
 * For example, 5 ! = 5 * 4 * 3 * 2 * 1 = 120
 * The value of 0! is 1, according to the convention for an empty product.
 * The factorial operation is encountered in many areas of mathematics, notably in combinatorics, algebra,
 * and mathematical analysis. Its most basic use counts the possible distinct sequences – the permutations –
 * of n distinct objects: there are n!.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial</a>
 * */
class Factorial {
    private static final IntPredicate isZeroOrOne = x -> x < 2;

    /*
     * Get factorial using recursion
     * */
    int getFactorialRecursionApproach(int n) {
        if (isZeroOrOne.test(n)) return 1;
        return n * getFactorialRecursionApproach(n - 1);
    }

    /*
     * Get factorial using java streams reduce
     * */
    int getFactorialStreamsApproach(int n) {
        if (isZeroOrOne.test(n)) return 1;
        return IntStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }
}
