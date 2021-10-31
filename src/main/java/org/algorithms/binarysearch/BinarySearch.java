package org.algorithms.binarysearch;

/*
 * Binary search, also known as half-interval search, logarithmic search, or binary chop, is a search algorithm
 * that finds the position of a target value within a sorted array. Binary search compares the target value
 * to the middle element of the array. If they are not equal, the half in which the target cannot lie is eliminated
 * and the search continues on the remaining half, again taking the middle element to compare to the target value,
 * and repeating this until the target value is found. If the search ends with the remaining half being empty,
 * the target is not in the array.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">Binary search algorithm</a>
 * */
public class BinarySearch {

    Integer search(int[] input, int item) {
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = input[mid];
            if (guess == item) return mid;
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}
