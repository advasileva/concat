package org.hse;

import org.hse.graph.Graph;
import org.hse.graph.GraphOf;
import org.hse.source.Content;
import org.hse.source.Source;
import org.hse.source.SourceDirectory;

import java.io.IOException;

public final class Concat {
    private final String source;
    private final String target;

    public Concat(final String source, final String target) {
        this.source = source;
        this.target = target;
    }

    public void exec() throws IOException {
        Source source = new SourceDirectory(this.source);
        Graph<Content> graph = new GraphOf<>(source.getDependencies());
        if (graph.hasCycle()) {

        } else {
            // for source in graph.reorder(); source.resolve();
        }
    }
}
