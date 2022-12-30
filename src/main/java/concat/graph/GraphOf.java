package concat.graph;

import java.security.InvalidAlgorithmParameterException;
import java.util.*;

/**
 * Directed graph implementation
 *
 * @param <T> type of graph vertices
 */
public final class GraphOf<T> implements Graph<T> {
    /**
     * Adjacency list for a directed graph
     */
    private final Map<T, List<T>> edges;

    /**
     * Ctor.
     *
     * @param edges adjacency list
     */
    public GraphOf(Map<T, List<T>> edges) {
        this.edges = edges;
    }

    @Override
    public Optional<List<T>> reorder() {
        try {
            return Optional.of(topologicalSort());
        } catch (InvalidAlgorithmParameterException exc) {
            return Optional.empty();
        }
    }

    /**
     * Sorts vertices in the connectivity component
     * using the topological sorting algorithm from the article:
     * https://habr.com/ru/post/100953/
     *
     * @return list of sorted vertices
     * @throws InvalidAlgorithmParameterException if there is a cycle
     */
    public List<T> topologicalSort() throws InvalidAlgorithmParameterException {
        List<T> order = new ArrayList<>();
        Set<T> white = new HashSet<>(edges.keySet());
        Set<T> gray = new HashSet<>();

        while (white.iterator().hasNext()) {
            dfs(white.iterator().next(), white, gray, order);
        }

        return order;
    }

    /**
     * Recursively DFS traversal
     *
     * @param curr  current vertex
     * @param white set of unvisited vertices
     * @param gray  set of partly visited vertices
     * @param order list of ordered visited vertices
     * @throws InvalidAlgorithmParameterException if there is a cycle
     */
    private void dfs(T curr, Set<T> white, Set<T> gray, List<T> order) throws InvalidAlgorithmParameterException {
        white.remove(curr);
        gray.add(curr);

        for (var vertex : edges.get(curr)) {
            if (gray.contains(vertex)) {
                printCycle(curr, gray);
                throw new InvalidAlgorithmParameterException();
            } else if (white.contains(vertex)) {
                dfs(vertex, white, gray, order);
            }
        }

        gray.remove(curr);
        order.add(curr);
    }

    /**
     * Prints cycle
     */
    private void printCycle(T curr, Set<T> cycle) {
        System.out.println("Cycle detected: vertex depends on itself");
        System.out.println("Dependent vertex: " + curr);
        System.out.println("The dependence was discovered at the stage of considering the vertices:");
        for (var vertex : cycle) {
            System.out.println(vertex);
        }
    }
}
