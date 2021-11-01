package org.algorithms.sorting;

import java.util.function.BiPredicate;

/*
 * In computer science, selection sort is an in-place comparison sorting algorithm.
 * It has an O(n2) time complexity, which makes it inefficient on large lists,
 * and generally performs worse than the similar insertion sort.
 * Selection sort is noted for its simplicity and has performance advantages over more complicated algorithms
 * in certain situations, particularly where auxiliary memory is limited.
 * The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to right
 * at the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
 * The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist
 * boundaries one element to the right.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort algorithm</a>
 *
 * This version of algorithm works without extra sorted array. There is used swapping elements in unsorted array.
 * */
class SelectionSorting {
    private static final BiPredicate<Integer, Integer> xGreaterThanY = (x, y) -> x > y;
    private static final BiPredicate<Integer, Integer> xLessThanY = (x, y) -> x < y;

    int[] sortASC(int[] input) {
        return sort(input, true);
    }

    int[] sortDESC(int[] input) {
        return sort(input, false);
    }

    private int[] sort(int[] input, boolean asc) {
        for (int i = 0; i < input.length - 1; i++) {
            int foundIndex = asc ? findSmallestIndex(input, i) : findBiggestIndex(input, i);
            int foundElement = input[foundIndex];
            int currentElement = input[i];
            input[i] = foundElement;
            input[foundIndex] = currentElement;
        }
        return input;
    }

    private int findSmallestIndex(int[] input, int startFrom) {
        return findIndexByPredicate(input, startFrom, xGreaterThanY);
    }

    private int findBiggestIndex(int[] input, int startFrom) {
        return findIndexByPredicate(input, startFrom, xLessThanY);
    }

    private int findIndexByPredicate(int[] input, int startFrom, BiPredicate<Integer, Integer> predicate) {
        int matchingPredicate = input[startFrom];
        int index = startFrom;
        for (int i = startFrom + 1; i < input.length; i++) {
            if (predicate.test(matchingPredicate, input[i])) {
                matchingPredicate = input[i];
                index = i;
            }
        }
        return index;
    }
}
