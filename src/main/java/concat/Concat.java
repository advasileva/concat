package concat;

import concat.graph.Graph;
import concat.graph.GraphOf;
import concat.source.Content;
import concat.source.Source;
import concat.source.SourceDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.InvalidAlgorithmParameterException;

public final class Concat {
    private final String source;
    private final String target;

    public Concat(final String source, final String target) {
        this.source = source;
        this.target = target;
    }

    public void exec() throws IOException, InvalidAlgorithmParameterException {
        Source source = new SourceDirectory(this.source, this.source);
        Graph<Content> graph = new GraphOf<>(source.getDependencies());
        if (graph.hasCycle()) {
            System.out.println("Ops");
        } else {
            Files.delete(Paths.get(target));
            Files.createFile(Paths.get(target));
            for (var content : graph.reorder()) {
                System.out.println(content.title());
                content.appendTo(target);
            }
        }
    }
}
