package repository;

import model.Track;

import java.util.List;
import java.util.UUID;

public interface ITrackRepository {

    List<Track> findAllTracks();

    Track findTrackById(UUID id);
}
