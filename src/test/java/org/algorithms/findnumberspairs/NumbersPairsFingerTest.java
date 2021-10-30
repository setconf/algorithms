package org.algorithms.findnumberspairs;

import org.javatuples.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class NumbersPairsFingerTest {

    private static Stream<Arguments> provideTestDataForFindKSumPairs() {
        return Stream.of(
                Arguments.of(5, List.of(2, 4, 7, 9, 0, 2, 3, 5, 1, 98, 3, 11, 23),
                        List.of(new Pair<>(2, 3), new Pair<>(0, 5), new Pair<>(4, 1))),
                Arguments.of(6, List.of(2, 4, 3, 3, 7, 9, 0, 2, 3, 5, 1, 98, 3, 11, 23),
                        List.of(new Pair<>(2, 4), new Pair<>(3, 3), new Pair<>(5, 1), new Pair<>(3, 3)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForFindKSumPairs")
    void findKSumPairsTest(int sum, List<Integer> input, List<Integer> expected) {
        NumbersPairsFinder pairsFinder = new NumbersPairsFinder();
        assertIterableEquals(expected, pairsFinder.findKSumPairs(sum, input));
    }
}
