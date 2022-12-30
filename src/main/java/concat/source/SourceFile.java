package concat.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The source that is the file with content
 */
public final class SourceFile extends SourceEnvelope implements Content {
    /**
     * Ctor.
     *
     * @param source absolute path to the source
     * @param root   absolute path to the root directory
     */
    public SourceFile(String source, String root) {
        super(source, root);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SourceFile other) {
            return hashCode() == other.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return title().hashCode();
    }

    @Override
    public Map<Content, List<Content>> getDependencies() throws IOException {
        List<Content> dependencies = new ArrayList<>();

        for (var line : getLines()) {
            if (line.startsWith("require ‘") && line.endsWith("’")) {
                String name = line.substring(9, line.length() - 1);
                String fullName = Path.of(getRoot(), name).toString();
                dependencies.add(new SourceFile(fullName, getRoot()));
            }
        }

        return Map.of(this, dependencies);
    }

    @Override
    public void appendTo(String path) throws IOException {
        Files.write(Path.of(path), getLines(), StandardOpenOption.APPEND);
    }

    @Override
    public String title() {
        return getPath().toString();
    }

    /**
     * Auxiliary method for getting a list of strings
     * (it is better to read one by one using an iterator)
     *
     * @return list of strings with file content
     * @throws IOException if there is a problem with the current file
     */
    private List<String> getLines() throws IOException {
        return Files.readAllLines(Path.of(getPath()));
    }

    @Override
    public String toString() {
        return title();
    }
}
