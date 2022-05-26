package service;

import model.Player;
import model.Score;
import repository.IScoreRepository;

import java.util.List;
import java.util.UUID;

public class ScoreService {

    private final IScoreRepository scoreRepository;

    public ScoreService(IScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllForPlayer(UUID playerId) {
        return scoreRepository.findAllForPlayer(playerId);
    }

    public void addToPlayer(UUID playerId, Score score) {
        scoreRepository.addToPlayer(playerId, score);
    }

    public int getTotalForPlayer(UUID playerId) {
        return getAllForPlayer(playerId).stream().map(Score::toInt).reduce(0, Integer::sum);
    }
}
