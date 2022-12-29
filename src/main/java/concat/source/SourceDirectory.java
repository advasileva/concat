package concat.source;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SourceDirectory extends SourceEnvelope {
    public SourceDirectory(String source) {
        super(source);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() throws IOException {
        var dependencies = new HashMap<Content, List<Content>>();
        for (var name : list()) {
            String fullName = Path.of(getPath().toString(), name).toString();
            var file = new File(fullName);
            Source source;

            if (file.isFile()) {
                source = new SourceFile(fullName);
            } else {
                source = new SourceDirectory(fullName);
            }

            dependencies.putAll(source.getDependencies());
        }
        return dependencies;
    }
}
