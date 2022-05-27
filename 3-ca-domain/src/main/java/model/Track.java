package model;

import java.util.UUID;

public class Track {

    private final UUID id;
    private final StrokeCount par;

    public Track(String id, int par) {
        this.id = UUID.fromString(id);
        this.par = new StrokeCount(par);
    }

    public UUID getId() {
        return id;
    }

    public StrokeCount getPar() {
        return par;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", par=" + par +
                '}';
    }
}
