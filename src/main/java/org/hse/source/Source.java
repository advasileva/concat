package org.hse.source;

import java.util.List;
import java.util.Map;

public interface Source {
    Map<Content, List<Content>> getDependencies();
}
