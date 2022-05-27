import exception.InvalidPlayernameException;
import model.Playername;
import model.StrokeCount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayernameTest {

    @Test
    void validValues() {
        assertDoesNotThrow(() -> new Playername("X"));
        assertDoesNotThrow(() -> new Playername("Test"));
        assertDoesNotThrow(() -> new Playername("123456789012345"));
    }

    @Test
    void invalidValues() {
        assertThrows(InvalidPlayernameException.class, () -> new Playername(""));
        assertThrows(InvalidPlayernameException.class, () -> new Playername("1234567890123456"));
    }

    @Test
    public void methods(){
        assertDoesNotThrow(() -> assertEquals("Test", new Playername("Test").toString()));
    }
}
