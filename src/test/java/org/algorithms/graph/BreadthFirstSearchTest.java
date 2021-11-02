package org.algorithms.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BreadthFirstSearchTest {
    private static final String root = "you";

    static Stream<Map<String, List<String>>> graphProvider() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put(root, List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy", root));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", List.of());
        graph.put("peggy", List.of("alice"));
        graph.put("thom", List.of());
        graph.put("jonny", List.of());
        return Stream.of(graph);
    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    void shouldFindSellerTest(Map<String, List<String>> graph) {
        final BreadthFirstSearch bfs = new BreadthFirstSearch();
        final Predicate<String> personIsSeller = name -> name.charAt(name.length() - 1) == 'm';
        final String expected = "thom";
        assertEquals(expected, bfs.search(graph, root, personIsSeller));
    }

    @ParameterizedTest
    @MethodSource("graphProvider")
    void shouldNotFindSellerTest(Map<String, List<String>> graph) {
        final BreadthFirstSearch bfs = new BreadthFirstSearch();
        final Predicate<String> personIsSeller = name -> name.charAt(name.length() - 1) == 'z';
        assertNull(bfs.search(graph, root, personIsSeller));
    }
}
