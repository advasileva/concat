package concat.source;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interface representing a source with some dependencies
 */
public interface Source {
    /**
     * Get content dependencies from other contents in the current source
     *
     * @return dependency map (key - what depends, value - list of dependencies)
     * @throws IOException if there is a problem with the output file
     */
    Map<Content, List<Content>> getDependencies() throws IOException;
}
