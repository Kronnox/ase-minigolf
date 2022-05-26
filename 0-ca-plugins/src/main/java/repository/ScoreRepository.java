package repository;

import model.Score;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public class ScoreRepository implements IScoreRepository {

    private final LinkedHashMap<UUID, List<Score>> scores;

    public ScoreRepository() {
        scores = new LinkedHashMap<>();
    }

    @Override
    public List<Score> findAllForPlayer(UUID playerId) {
        return scores.getOrDefault(playerId, new ArrayList<>());
    }

    @Override
    public void addToPlayer(UUID playerId, Score score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, new ArrayList<>());
        }
        scores.get(playerId).add(score);
    }
}
