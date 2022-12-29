package concat.source;

import java.io.File;
import java.nio.file.Path;

public abstract class SourceEnvelope implements Source {
    private final File source;

    private final String root;

    protected SourceEnvelope(String source, String root) {
        this.source = new File(source);
        this.root = root;
    }

    protected Path getPath() {
        return source.toPath();
    }

    protected String[] list() {
        return source.list();
    }

    protected String getRoot() {
        return root;
    }
}
