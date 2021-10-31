package org.algorithms.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    private final static int[] input = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    private static Stream<Arguments> provideTestDataForBinarySearch() {
        return Stream.of(
                Arguments.of(input, 10, 15),
                Arguments.of(input, 0, 5),
                Arguments.of(input, 911, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForBinarySearch")
    void findKSumPairsTest(int[] input, Integer item, Integer expected) {
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(expected, binarySearch.search(input, item));
    }
}
