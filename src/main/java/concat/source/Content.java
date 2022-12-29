package concat.source;

import java.io.IOException;

public interface Content {
    void appendTo(String path) throws IOException;

    String title();
}
