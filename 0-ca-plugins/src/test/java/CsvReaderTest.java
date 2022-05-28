import exception.InvalidPlayernameException;
import file.CsvReader;
import model.Playername;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    @Test
    void invalidPath() {
        assertThrows(FileNotFoundException.class, () -> CsvReader.read("none.csv", "; "));
    }

    @Test
    public void validPath(){
        assertDoesNotThrow(() -> {
            List<String[]> lines = CsvReader.read("test.csv", "; ");
            assertEquals(3, lines.size());
            assertEquals("Test22", lines.get(1)[1]);
        });
    }
}
