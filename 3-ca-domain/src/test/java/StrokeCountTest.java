import model.StrokeCount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrokeCountTest {

    @Test
    void validValues() {
        assertDoesNotThrow(() -> new StrokeCount(1));
        assertDoesNotThrow(() -> new StrokeCount(12));
        assertDoesNotThrow(() -> new StrokeCount(Integer.MAX_VALUE));
    }

    @Test
    void invalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new StrokeCount(-1));
        assertThrows(IllegalArgumentException.class, () -> new StrokeCount(0));
    }

    @Test
    public void methods(){
        assertDoesNotThrow(() -> {
            assertEquals(10, new StrokeCount(10).toInt());
            assertEquals("10", new StrokeCount(10).toString());
        });
    }
}
