package org.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class QuickSortingTest {

    private static Stream<Arguments> provideTestDataForShouldSortTest() {
        return Stream.of(
                Arguments.of(List.of(21, -4, 5, 11, 5, -23, 1, 2, 5, 11, 9, 15),
                        List.of(-23, -4, 1, 2, 5, 5, 5, 9, 11, 11, 15, 21)),
                Arguments.of(List.of(-5, 5, -3, 3, -1, 1, 15, 0, 0, 15),
                        List.of(-5, -3, -1, 0, 0, 1, 3, 5, 15, 15))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForShouldSortTest")
    void shouldSortTest(List<Integer> input, List<Integer> expected) {
        QuickSorting sorting = new QuickSorting();
        assertIterableEquals(expected, sorting.sort(input));
    }
}
