package org.algorithms.sorting;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Quicksort is an in-place sorting algorithm. Developed by British computer scientist Tony Hoare in 1959
 * and published in 1961, it is still a commonly used algorithm for sorting. When implemented well, it can be somewhat
 * faster than merge sort and about two or three times faster than heapsort.
 *
 * Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning
 * the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
 * For this reason, it is sometimes called partition-exchange sort. The sub-arrays are then sorted recursively.
 * This can be done in-place, requiring small additional amounts of memory to perform the sorting.
 *
 * Quicksort is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation
 * (formally, a total order) is defined. Efficient implementations of Quicksort are not a stable sort, meaning
 * that the relative order of equal sort items is not preserved.
 *
 * Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) comparisons to sort n items.
 * In the worst case, it makes O(n2) comparisons.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Quicksort</a>
 * */
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
