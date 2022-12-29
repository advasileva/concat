package concat.graph;

import java.security.InvalidAlgorithmParameterException;
import java.util.*;

public final class GraphOf<T> implements Graph<T> {
    private final Map<T, List<T>> edges;

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
