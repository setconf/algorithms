package org.algorithms.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GreedyAlgorithmTest {

    private static Stream<Arguments> testDataProvider() {
        Set<String> states = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));
        List<String> expected = List.of("kone", "ktwo", "kthree", "kfive");
        return Stream.of(Arguments.of(states, stations, expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void shouldFindStationsTest(Set<String> states, Map<String, Set<String>> stations, List<String> expected) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        assertIterableEquals(expected, greedyAlgorithm.findStations(states, stations));
    }
}
