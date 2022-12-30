package concat.graph;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

/**
 * Interface representing a graph
 * @param <T> type of graph vertices
 */
public interface Graph<T> {
    /**
     * Check if there is a cycle in the graph
     * @return checking result
     */
    Boolean hasCycle();

    /**
     * Sorts the vertices of the graph so that all
     * dependent vertices are earlier than the current vertex
     * @return list of sorted vertices
     * @throws InvalidAlgorithmParameterException TODO del
     */
    List<T> reorder() throws InvalidAlgorithmParameterException;
}
