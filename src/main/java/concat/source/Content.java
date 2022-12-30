package concat.source;

import java.io.IOException;

/**
 * Interface representing an entity with content
 */
public interface Content {
    /**
     * Add content to the end of some file
     *
     * @param path absolute path to the output file
     * @throws IOException if there is a problem with the output file
     */
    void appendTo(String path) throws IOException;

    /**
     * Get the title of the content
     *
     * @return string representation of the title
     */
    String title();
}
