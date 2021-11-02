package org.algorithms.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.algorithms.graph.DijkstraAlgorithm.FIN;
import static org.algorithms.graph.DijkstraAlgorithm.START;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraAlgorithmTest {

    private static Stream<Arguments> graphProvider() {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        graph.put(START, new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);
        graph.put(FIN, new HashMap<>());
        Map<String, Double> expectedCosts = new HashMap<>();
        expectedCosts.put("a", 5.0);
        expectedCosts.put("b", 2.0);
        expectedCosts.put("fin", 6.0);
        return Stream.of(Arguments.of(graph, expectedCosts));
    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    void dijkstraAlgorithmTest(Map<String, Map<String, Double>> graph, Map<String, Double> expectedCosts) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        assertEquals(expectedCosts, dijkstraAlgorithm.shortestPath(graph));
    }
}
