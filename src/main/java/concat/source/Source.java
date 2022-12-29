package concat.source;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Source {
    Map<Content, List<Content>> getDependencies() throws IOException;
}
