package org.hse;

import java.util.List;
import java.util.Map;

public final class SourceFile extends SourceEnvelope implements Content {
    protected SourceFile(String source) {
        super(source);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() {
        return null;
    }
}
