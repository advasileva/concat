package concat.source;

import java.io.File;
import java.nio.file.Path;

/**
 * Decorator for the source that controls access
 */
public abstract class SourceEnvelope implements Source {
    /**
     * Source itself
     */
    private final File source;

    /**
     * AAbsolute path to the root directory of the source
     */
    private final String root;

    /**
     * Ctor.
     *
     * @param source absolute path to the source
     * @param root   absolute path to the root directory
     */
    protected SourceEnvelope(String source, String root) {
        this.source = new File(source);
        this.root = root;
    }

    /**
     * TODO check and fix
     *
     * @return
     */
    protected Path getPath() {
        return source.toPath();
    }

    /**
     * Get a list of child files and directories
     *
     * @return list of string representations of their paths
     */
    protected String[] list() {
        return source.list();
    }

    /**
     * Get the absolute path to the root directory
     *
     * @return string representation of the path
     */
    protected String getRoot() {
        return root;
    }
}
