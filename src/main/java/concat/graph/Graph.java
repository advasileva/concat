package concat.graph;

import java.util.List;
import java.util.Optional;

/**
 * Interface representing a graph
 * @param <T> type of graph vertices
 */
public interface Graph<T> {
    /**
     * Sorts the vertices of the graph so that all
     * dependent vertices are earlier than the current vertex
     * @return list of sorted vertices
     */
    Optional<List<T>> reorder();
}
