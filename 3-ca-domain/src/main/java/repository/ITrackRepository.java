package repository;

import model.Track;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITrackRepository {

    List<Track> findAll();

    Optional<Track> findById(UUID id);
}
