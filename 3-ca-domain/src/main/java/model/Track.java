package model;

import java.util.UUID;

public class Track {

    private final UUID id;
    private final int par;

    public Track(UUID id, int par) {
        this.id = id;
        this.par = par;
    }

    public UUID getId() {
        return id;
    }

    public int getPar() {
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
