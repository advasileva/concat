package org.hse.source;

import java.io.File;
import java.nio.file.Path;

public abstract class SourceEnvelope implements Source {
    private final File source;

    protected SourceEnvelope(String source) {
        this.source = new File(source);
    }

    protected Path getPath() {
        return source.toPath();
    }

    protected String[] list() {
        return source.list();
    }
}
