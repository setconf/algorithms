package org.algorithms.greedy;

import java.util.*;

/*
 * A greedy algorithm is any algorithm that follows the problem-solving heuristic of making the locally optimal choice
 * at each stage. In many problems, a greedy strategy does not produce an optimal solution, but a greedy heuristic can
 * yield locally optimal solutions that approximate a globally optimal solution in a reasonable amount of time.
 *
 * For example, a greedy strategy for the travelling salesman problem (which is of high computational complexity)
 * is the following heuristic: "At each step of the journey, visit the nearest unvisited city."
 * This heuristic does not intend to find the best solution, but it terminates in a reasonable number of steps,
 * finding an optimal solution to such a complex problem typically requires unreasonably many steps.
 * In mathematical optimization, greedy algorithms optimally solve combinatorial problems having the properties of
 * matroids and give constant-factor approximations to optimization problems with the submodular structure.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Greedy_algorithm">Greedy algorithm</a>
 * */
class GreedyAlgorithm {

    /*
     * You open your own authoring program on the radio and want to be heard in all states.
     * You need to decide on which radio stations your program should be broadcast.
     * Each station costs money, so the number of stations must be kept to a minimum.
     * There is a list of stations.
     * */
    List<String> findStations(Set<String> states, Map<String, Set<String>> stations) {
        List<String> foundStations = new ArrayList<>();
        while (!states.isEmpty()) {
            int maxStatesCount = 0;
            String bestStation = null;
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                Set<String> stationCoverages = entry.getValue();
                Set<String> covered = intersection(states, stationCoverages);
                if (covered.size() > maxStatesCount) {
                    maxStatesCount = covered.size();
                    bestStation = entry.getKey();
                }
            }
            foundStations.add(bestStation);
            states.removeAll(stations.get(bestStation));
            stations.remove(bestStation);
        }
        return foundStations;
    }

    private Set<String> intersection(Set<String> states, Set<String> stationCoverages) {
        Set<String> result = new HashSet<>(states);
        result.retainAll(stationCoverages);
        return result;
    }
}
