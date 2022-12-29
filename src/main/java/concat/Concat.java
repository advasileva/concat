package concat;

import concat.source.Source;
import concat.source.SourceDirectory;

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
        var deps = source.getDependencies();
        for(var d : deps.keySet()) {
            System.out.println(d + " : " + deps.get(d));
        }
//        Graph<Content> graph = new GraphOf<>(source.getDependencies());
//        if (graph.hasCycle()) {
//
//        } else {
//            // for source in graph.reorder(); source.resolve();
//        }
    }
}
