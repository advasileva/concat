package org.hse.source;

import java.util.List;
import java.util.Map;

public final class SourceDirectory extends SourceEnvelope {
    public SourceDirectory(String source) {
        super(source);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() {
        return null;
    }
}
