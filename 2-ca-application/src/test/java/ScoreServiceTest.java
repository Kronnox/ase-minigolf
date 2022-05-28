import model.Player;
import model.PlayerScoreAggregate;
import model.Score;
import model.StrokeCount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IPlayerScoreRepository;
import service.ScoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreServiceTest {

    IPlayerScoreRepository repo;
    Player player;

    @BeforeEach
    public void setup() {
        Score score = mock(Score.class);
        when(score.toInt()).thenReturn(6);

        player = mock(Player.class);

        PlayerScoreAggregate playerScore = mock(PlayerScoreAggregate.class);
        when(playerScore.getScores()).thenReturn(new ArrayList<>(){{
            add(score);
        }});

        repo = mock(IPlayerScoreRepository.class);
        when(repo.findByPlayer(any())).thenReturn(Optional.of(playerScore));
    }

    @Test
    public void getAllForPlayer() {
        assertDoesNotThrow(() -> {
            ScoreService service = new ScoreService(repo);
            List<Score> scores = service.getAllForPlayer(player);
            assertEquals(1, scores.size());
            assertEquals(6, scores.get(0).toInt());
        });
    }
}
