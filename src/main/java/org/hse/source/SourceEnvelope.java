package org.hse.source;

import java.io.File;

public abstract class SourceEnvelope implements Source {
    private final File source;

    protected SourceEnvelope(String source) {
        this.source = new File(source);
    }
}
