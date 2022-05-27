package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {

    private final UUID id;
    private final String name;
    private final StrokeCount maxStrokes;
    private final List<Track> tracks;

    public Course(String id, String name, int maxStrokes) {
        this.id = UUID.fromString(id);
        this.name = name;
        this.maxStrokes = new StrokeCount(maxStrokes);
        tracks = new ArrayList<>(); //ToDo: Track
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StrokeCount getMaxStrokes() {
        return maxStrokes;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Track getTrack(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be smaller than 0");
        }
        if (index > tracks.size()) {
            throw new IndexOutOfBoundsException("Index cannot be larger than track count");
        }

        return tracks.get(index);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxStrokes=" + maxStrokes +
                ", tracks=" + tracks +
                '}';
    }
}
