package concat.graph;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

public interface Graph<T> {
    Boolean hasCycle();

    List<T> reorder() throws InvalidAlgorithmParameterException;
}
