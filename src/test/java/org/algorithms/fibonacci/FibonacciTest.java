package org.algorithms.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FibonacciTest {

    private static Stream<Arguments> provideFibonacciNumbers() {
        return Stream.of(
                Arguments.of(1, List.of(0)),
                Arguments.of(2, List.of(0, 1)),
                Arguments.of(3, List.of(0, 1, 1)),
                Arguments.of(4, List.of(0, 1, 1, 2)),
                Arguments.of(15, List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377))
        );
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciNumbers")
    void shouldGenerateFirstNFibonacciNumbersTest(int input, List<Integer> expected) {
        Fibonacci fibonacci = new Fibonacci();
        assertIterableEquals(expected, fibonacci.firstNFibonacciNumbers(input).collect(Collectors.toList()));
    }
}
