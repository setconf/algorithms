package org.algorithms.findnumberspairs;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NumbersPairsFinder {

    /*
     * Find all K-Sum Pairs
     * You are given an integer list nums and an integer k.
     * In one operation, you can pick two numbers from the array whose sum equals k,
     * than and add it to output and remove them from the array.
     * Return the all nums pairs whose sum equals k.
     * */
    List<Pair<Integer, Integer>> findKSumPairs(int sum, List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair<Integer, Integer>> pairs = new LinkedList<>();
        for (Integer elem : numbers) {
            Integer founded = map.get(sum - elem);
            map.put(elem, elem);
            if (founded == null) continue;
            map.remove(founded);
            map.remove(elem);
            pairs.add(new Pair<>(founded, elem));
        }
        return pairs;
    }
}
