import file.CsvReader;
import model.Track;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import repository.TrackRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class TrackRepositoryTest {

    @Test
    void findAll() {
        LinkedList<String[]> tracks = new LinkedList<>();
        tracks.add(new String[]{"13935c14-0929-40ee-9379-c7aa002c163e", "4"});
        tracks.add(new String[]{"448ed1b6-8ea3-44b9-afaa-446715bde61a", "6"});

        List<Track> findAll;
        try (MockedStatic<CsvReader> mockedReader = Mockito.mockStatic(CsvReader.class)) {
            mockedReader.when(() -> CsvReader.read(any(), any())).thenReturn(tracks);

            TrackRepository repo = new TrackRepository();
            findAll = repo.findAll();
        }
        assertEquals(2, findAll.size());
    }

    @Test
    void findOne() {
        LinkedList<String[]> tracks = new LinkedList<>();
        tracks.add(new String[]{"13935c14-0929-40ee-9379-c7aa002c163e", "4"});
        tracks.add(new String[]{"448ed1b6-8ea3-44b9-afaa-446715bde61a", "6"});

        UUID trackId = UUID.fromString("448ed1b6-8ea3-44b9-afaa-446715bde61a");

        Optional<Track> findOne;
        try (MockedStatic<CsvReader> mockedReader = Mockito.mockStatic(CsvReader.class)) {
            mockedReader.when(() -> CsvReader.read(any(), any())).thenReturn(tracks);

            TrackRepository repo = new TrackRepository();
            findOne = repo.findById(trackId);
        }
        assertTrue(findOne.isPresent());
    }

    @Test
    void findInvalid() {
        LinkedList<String[]> tracks = new LinkedList<>();
        tracks.add(new String[]{"13935c14-0929-40ee-9379-c7aa002c163e", "4"});
        tracks.add(new String[]{"448ed1b6-8ea3-44b9-afaa-446715bde61a", "6"});

        UUID trackId = UUID.fromString("8af410f8-fd74-4e20-832d-3bca4914b6f6");

        Optional<Track> findOne;
        try (MockedStatic<CsvReader> mockedReader = Mockito.mockStatic(CsvReader.class)) {
            mockedReader.when(() -> CsvReader.read(any(), any())).thenReturn(tracks);

            TrackRepository repo = new TrackRepository();
            findOne = repo.findById(trackId);
        }
        assertTrue(findOne.isEmpty());
    }
}
