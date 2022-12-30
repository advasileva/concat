package concat;

import concat.graph.Graph;
import concat.graph.GraphOf;
import concat.source.Content;
import concat.source.Source;
import concat.source.SourceDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;

/**
 * Class that performs concatenation at a high level
 */
public final class Concat {
    /**
     * Absolute path to the input directory
     */
    private final String source;

    /**
     * Absolute path to the output file
     */
    private final String target;

    /**
     * Ctor.
     *
     * @param source absolute path to the input directory
     * @param target absolute path to the output file
     */
    public Concat(final String source, final String target) {
        this.source = source;
        this.target = target;
    }

    /**
     * High-level execution pipeline
     *
     * @throws IOException                        if there is a problem with the paths TODO why?
     *                                                                                       TODO del:
     * @throws InvalidAlgorithmParameterException
     */
    public void exec() throws IOException, InvalidAlgorithmParameterException {
        Source source = new SourceDirectory(this.source, this.source);
        Graph<Content> graph = new GraphOf<>(source.getDependencies());

        if (graph.hasCycle()) {
            // TODO specify
            System.out.println("Ops");
        } else {
            // TODO optimize
            Files.delete(Paths.get(target));
            Files.createFile(Paths.get(target));
            for (var content : graph.reorder()) {
                // TODO maybe del print
                System.out.println(content.title());
                content.appendTo(target);
            }
        }
    }
}
