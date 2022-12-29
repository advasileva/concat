package concat.graph;

import java.util.List;

public interface Graph<T> {
    Boolean hasCycle();

    List<T> reorder();
}
