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
    public Boolean hasCycle() {
        try {
            reorder();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public List<T> reorder() throws InvalidAlgorithmParameterException {
        List<T> order = new ArrayList<>();
        Set<T> white = new HashSet<>(edges.keySet());
        Set<T> gray = new HashSet<>();
        Set<T> black = new HashSet<>();

        while (white.iterator().hasNext()) {
            dfs(white.iterator().next(), white, gray, black, order);
        }

        return order;
    }

    /**
     * Recursively sorts vertices in the connectivity component
     * using the topological sorting algorithm from the article:
     * https://habr.com/ru/post/100953/
     *
     * @param curr  current vertex
     * @param white set of unvisited vertices
     * @param gray  set of partly visited vertices
     * @param black TODO del
     * @param order list of ordered visited vertices
     * @throws InvalidAlgorithmParameterException TODO refactor
     */
    private void dfs(T curr, Set<T> white, Set<T> gray, Set<T> black, List<T> order) throws InvalidAlgorithmParameterException {
        white.remove(curr);
        gray.add(curr);
        for (var vertice : edges.get(curr)) {
            if (gray.contains(vertice)) {
                throw new InvalidAlgorithmParameterException();
            } else if (white.contains(vertice)) {
                dfs(vertice, white, gray, black, order);
            }
        }

        gray.remove(curr);
        black.add(curr);
        order.add(curr);
    }
}
