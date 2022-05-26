package repository;

import model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TrackRepository implements ITrackRepository{

    List<Track> tracks = new ArrayList<>(){{
        add(new Track(UUID.fromString("7da8e2d3-7932-4821-9749-e39404214e95"), 4));
        add(new Track(UUID.fromString("7b2970cb-0fe1-4c12-885f-51d6ca305a61"), 5));
        add(new Track(UUID.fromString("16848460-b80b-4ec9-a2d5-cf831a6cd8f4"), 4));
        add(new Track(UUID.fromString("7b1cd5b6-c5da-4be4-843a-4b64892aabb1"), 6));
    }};

    @Override
    public List<Track> findAll() {
        return tracks;
    }

    @Override
    public Optional<Track> findById(UUID id) {
        return tracks.stream().filter(c -> c.getId().equals(id)).findAny();
    }
}
