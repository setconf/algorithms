package org.algorithms.graph;

import java.util.*;
import java.util.function.Predicate;

/*
 * Breadth-first search (BFS) is an algorithm for searching a tree data structure for a node that satisfies
 * a given property. It starts at the tree root and explores all nodes at the present depth prior to moving
 * on to the nodes at the next depth level. Extra memory, usually a queue, is needed to keep track of the child
 * nodes that were encountered but not yet explored.
 *
 * For example, in a chess endgame a chess engine may build the game tree from the current position by applying
 * all possible moves, and use breadth-first search to find a win position for white.
 * Implicit trees (such as game trees or other problem-solving trees) may be of infinite size,
 * breadth-first search is guaranteed to find a solution node if one exists.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Breadth-first_search">Breadth-first search</a>
 * */
public class BreadthFirstSearch {

    /*
     * This method find person who is seller in friends graph.
     * We use Map<String, List<String>> for graph representation.
     * */
    public String search(Map<String, List<String>> graph, String root, Predicate<String> searchCondition) {
        Queue<String> queue = new LinkedList<>(graph.get(root));
        List<String> serched = new ArrayList<>();
        while (!queue.isEmpty()) {
            String person = queue.poll();
            if (serched.contains(person)) continue;
            if (searchCondition.test(person)) return person;
            queue.addAll(graph.get(person));
            serched.add(person);
        }
        return null;
    }
}
