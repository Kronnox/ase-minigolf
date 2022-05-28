package repository;

import model.Player;
import model.PlayerScoreAggregate;
import storage.GenericStorage;
import storage.StorageManager;

import java.util.*;

public class PlayerScoreRepository implements IPlayerScoreRepository {

    private final GenericStorage<PlayerScoreAggregate> scores = StorageManager.getScoreStorage();

    @Override
    public Optional<PlayerScoreAggregate> findByPlayer(Player player) {
        return scores.retrieve().stream().filter(s -> s.getPlayer().equals(player)).findAny();
    }

    @Override
    public void save(PlayerScoreAggregate score) {
        scores.store(score);
    }
}
