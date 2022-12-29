package concat.source;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public final class SourceFile extends SourceEnvelope implements Content {
    protected SourceFile(String source) {
        super(source);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Map<Content, List<Content>> getDependencies() throws IOException {
        List<Content> dependencies = new ArrayList<>();

        for(var line : Files.readAllLines(getPath(), Charset.defaultCharset())) {
            if (line.startsWith("require ‘") && line.endsWith("’")) {
                String name = line.substring(9, line.length() - 1);
                dependencies.add(new SourceFile(name));
            }
        }

        return Map.of(this, dependencies);
    }
}
