package concat.source;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source that is the directory
 */
public final class SourceDirectory extends SourceEnvelope {
    /**
     * Ctor.
     *
     * @param source absolute path to the source
     * @param root   absolute path to the root directory
     */
    public SourceDirectory(String source, String root) {
        super(source, root);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() throws IOException {
        var dependencies = new HashMap<Content, List<Content>>();
        for (var name : list()) {
            String fullName = Path.of(getPath(), name).toString();
            var file = new File(fullName);
            Source source;

            if (file.isFile()) {
                source = new SourceFile(fullName, getRoot());
            } else {
                source = new SourceDirectory(fullName, getRoot());
            }

            dependencies.putAll(source.getDependencies());
        }
        return dependencies;
    }
}
