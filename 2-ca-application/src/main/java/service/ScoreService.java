package service;

import model.Player;
import model.PlayerScoreAggregate;
import model.Score;
import repository.IPlayerScoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreService {

    private final IPlayerScoreRepository scoreRepository;

    public ScoreService(IPlayerScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllForPlayer(Player player) {
        Optional<PlayerScoreAggregate> optionalScore = scoreRepository.findByPlayer(player);
        if (optionalScore.isEmpty()) {
            return new ArrayList<>();
        }
        return optionalScore.get().getScores();
    }

    public void addToPlayer(Player player, Score score) {
        Optional<PlayerScoreAggregate> optionalScore = scoreRepository.findByPlayer(player);
        if (optionalScore.isEmpty()) {
            PlayerScoreAggregate playerScore = new PlayerScoreAggregate(player);
            playerScore.addScore(score);
            scoreRepository.save(playerScore);
            return;
        }
        optionalScore.get().addScore(score);
    }
}
