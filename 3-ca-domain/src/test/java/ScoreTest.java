import model.Score;
import model.StrokeCount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @Test
    void validValues() {
        assertDoesNotThrow(() -> new Score(new StrokeCount(1)));
        assertDoesNotThrow(() -> new Score(new StrokeCount(12)));
        assertDoesNotThrow(() -> new Score(new StrokeCount(Integer.MAX_VALUE-2)));
    }

    @Test
    void invalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new Score(new StrokeCount(Integer.MAX_VALUE)));
    }

    @Test
    public void setToMax(){
        assertDoesNotThrow(() -> {
            Score score = new Score(new StrokeCount(2));
            score.setToMax();
            assertEquals(4, score.toInt());
        });
    }

    @Test
    public void increment(){
        assertDoesNotThrow(() -> {
            Score score = new Score(new StrokeCount(2));
            assertEquals(1, score.toInt());
            score.increment();
            assertEquals(2, score.toInt());
            score.increment();
            assertEquals(4, score.toInt());
        });
    }
}
