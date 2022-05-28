package repository;

import model.Player;
import model.PlayerScoreAggregate;
import model.Score;

import java.util.List;
import java.util.Optional;

public interface IPlayerScoreRepository {

    Optional<PlayerScoreAggregate> findByPlayer(Player player);

    void save(PlayerScoreAggregate score);
}
