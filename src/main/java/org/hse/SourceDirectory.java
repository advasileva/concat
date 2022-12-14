package org.hse;

import java.util.List;
import java.util.Map;

public final class SourceDirectory extends SourceEnvelope {
    protected SourceDirectory(String source) {
        super(source);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() {
        return null;
    }
}
