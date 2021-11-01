package org.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SelectionSortingTest {

    private static Stream<Arguments> provideTestDataForShouldSortASCTest() {
        return Stream.of(
                Arguments.of(new int[]{21, -4, 5, 11, 5, -23, 1, 2, 5, 11, 9, 15},
                        List.of(-23, -4, 1, 2, 5, 5, 5, 9, 11, 11, 15, 21)),
                Arguments.of(new int[]{-5, 5, -3, 3, -1, 1, 15, 0, 0, 15},
                        List.of(-5, -3, -1, 0, 0, 1, 3, 5, 15, 15))
        );
    }

    private static Stream<Arguments> provideTestDataForShouldSortDECSTest() {
        return Stream.of(
                Arguments.of(new int[]{21, -4, 5, 11, 5, -23, 1, 2, 5, 11, 9, 15},
                        List.of(21, 15, 11, 11, 9, 5, 5, 5, 2, 1, -4, -23)),
                Arguments.of(new int[]{-5, 5, -3, 3, -1, 1, 15, 0, 0, 15},
                        List.of(15, 15, 5, 3, 1, 0, 0, -1, -3, -5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForShouldSortASCTest")
    void shouldSortASCTest(int[] input, List<Integer> expected) {
        SelectionSorting sorting = new SelectionSorting();
        assertIterableEquals(expected, Arrays.stream(sorting.sortASC(input)).boxed().collect(Collectors.toList()));
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForShouldSortDECSTest")
    void shouldSortDECSTest(int[] input, List<Integer> expected) {
        SelectionSorting sorting = new SelectionSorting();
        assertIterableEquals(expected, Arrays.stream(sorting.sortDESC(input)).boxed().collect(Collectors.toList()));
    }
}
