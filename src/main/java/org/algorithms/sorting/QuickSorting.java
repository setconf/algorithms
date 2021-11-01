package org.algorithms.sorting;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSorting {
    private static final IntPredicate isZeroOrOne = x -> x < 2;

    List<Integer> sort(List<Integer> input) {
        if (isZeroOrOne.test(input.size())) return input;
        int pivotElement = input.get(0);
        List<Integer> less = input.stream().skip(1).filter(e -> e <= pivotElement).collect(Collectors.toList());
        Stream<Integer> pivot = Stream.of(pivotElement);
        List<Integer> greater = input.stream().skip(1).filter(e -> e > pivotElement).collect(Collectors.toList());
        return Stream.of(sort(less).stream(), pivot, sort(greater).stream())
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }
}
