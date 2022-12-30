package concat;

import concat.graph.Graph;
import concat.graph.GraphOf;
import concat.source.Content;
import concat.source.Source;
import concat.source.SourceDirectory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
     * @throws IOException if there is a problem with the paths
     */
    public void exec() throws IOException {
        Source source = new SourceDirectory(this.source, this.source);
        Graph<Content> graph = new GraphOf<>(source.getDependencies());

        Optional<List<Content>> sortedContent = graph.reorder();
        if (sortedContent.isEmpty()) {
            System.out.println("The work cannot be continued");
        } else {
            File targetFile = new File(target);
            targetFile.delete();
            targetFile.createNewFile();
            System.out.println("Sorted list:");
            for (var content : sortedContent.get()) {
                System.out.println(content.title());
                content.appendTo(target);
            }
        }
    }
}
