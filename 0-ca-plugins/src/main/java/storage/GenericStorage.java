package storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple helper class to simulate any real storage solution for this project.
 * "Persistent" storage for the runtime of the application.
 * @param <T> type of stored medium
 */
public class GenericStorage<T> {

    private final List<T> content = new ArrayList<>();

    public void store(T object) {
        content.add(object);
    }

    public List<T> retrieve() {
        return content;
    }
}
