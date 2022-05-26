package repository;

import model.Score;

import java.util.List;
import java.util.UUID;

public interface IScoreRepository {

    List<Score> findAllForPlayer(UUID playerId);

    void addToPlayer(UUID playerId, Score score);
}
