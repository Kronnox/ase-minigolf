package repository;

import file.CsvReader;
import model.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TrackRepository implements ITrackRepository{

    private final String TRACK_FILE_PATH = "tracks.csv";
    private final List<Track> tracks = new ArrayList<>();

    public TrackRepository() {
        List<String[]> fileContent;
        try {
            fileContent = CsvReader.read(TRACK_FILE_PATH, "; ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        fileContent.forEach(line -> tracks.add(new Track(line[0], Integer.parseInt(line[1]))));
    }

    @Override
    public List<Track> findAll() {
        return tracks;
    }

    @Override
    public Optional<Track> findById(UUID id) {
        return tracks.stream().filter(c -> c.getId().equals(id)).findAny();
    }
}
