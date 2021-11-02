package org.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a graph, which may represent,
 * for example, road networks. It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three
 * years later. The algorithm exists in many variants. Dijkstra's original algorithm found the shortest path between
 * two given nodes, but a more common variant fixes a single node as the "source" node and finds shortest paths from
 * the source to all other nodes in the graph, producing a shortest-path tree.
 *
 * For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
 * It can also be used for finding the shortest paths from a single node to a single destination node by stopping
 * the algorithm once the shortest path to the destination node has been determined.
 * For example, if the nodes of the graph represent cities and edge path costs represent driving distances
 * between pairs of cities connected by a direct road (for simplicity, ignore red lights, stop signs, toll roads
 * and other obstructions), Dijkstra's algorithm can be used to find the shortest route between one city and
 * all other cities. A widely used application of shortest path algorithms is network routing protocols,
 * most notably IS-IS (Intermediate System to Intermediate System) and Open Shortest Path First (OSPF).
 * It is also employed as a subroutine in other algorithms such as Johnson's.
 *
 * The Dijkstra algorithm uses labels that are positive integers or real numbers, which are totally ordered.
 * It can be generalized to use any labels that are partially ordered, provided the subsequent labels
 * (a subsequent label is produced when traversing an edge) are monotonically non-decreasing.
 * This generalization is called the generic Dijkstra shortest-path algorithm.[8]
 *
 * @see <a href="https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm">Dijkstra's algorithm</a>
 * */
class DijkstraAlgorithm {
    static final String START = "start";
    static final String FIN = "fin";

    Map<String, Double> shortestPath(Map<String, Map<String, Double>> graph) {
        Map<String, Double> costs = initCosts(graph);
        Map<String, String> parents = initParents(graph);
        List<String> processed = new ArrayList<>();
        String node = findLowestCostNode(costs, processed);
        while (node != null) {
            Double cost = costs.get(node);
            Map<String, Double> neighbours = graph.get(node);
            for (Map.Entry<String, Double> neighbour : neighbours.entrySet()) {
                Double newCost = cost + neighbour.getValue();
                if (costs.get(neighbour.getKey()) > newCost) {
                    costs.put(neighbour.getKey(), newCost);
                    parents.put(neighbour.getKey(), node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }
        return costs;
    }

    private String findLowestCostNode(Map<String, Double> costs, List<String> processed) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    private Map<String, Double> initCosts(Map<String, Map<String, Double>> graph) {
        Map<String, Double> costs = new HashMap<>(graph.get(START));
        costs.put(FIN, Double.POSITIVE_INFINITY);
        return costs;
    }

    private Map<String, String> initParents(Map<String, Map<String, Double>> graph) {
        Map<String, String> parents = new HashMap<>();
        graph.get(START).keySet().forEach(k -> parents.put(k, START));
        parents.put(FIN, null);
        return parents;
    }
}
