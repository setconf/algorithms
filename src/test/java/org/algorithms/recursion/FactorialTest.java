package org.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

    @ParameterizedTest
    @CsvSource({"0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "10, 3628800"
    })
    void factorialTest(int number, int expected) {
        Factorial factorial = new Factorial();
        assertEquals(expected, factorial.getFactorialRecursionApproach(number));
        assertEquals(expected, factorial.getFactorialStreamsApproach(number));
    }
}
