package concat.graph;

import java.util.List;
import java.util.Map;

public final class GraphOf<T> implements Graph<T> {
    private final Map<T, List<T>> edges;

    public GraphOf(Map<T, List<T>> edges) {
        this.edges = edges;
    }

    @Override
    public Boolean hasCycle() {
        return null;
    }

    @Override
    public List<T> reorder() {
        return null;
    }
}
