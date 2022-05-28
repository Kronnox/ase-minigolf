package storage;

import model.Player;
import model.PlayerScoreAggregate;

/**
 * Simple helper class to simulate any real storage solution for this project.
 * Static entrypoint for all in memory storage.
 */
public class StorageManager {

    private static final GenericStorage<Player> playerStorage = new GenericStorage<>();
    private static final GenericStorage<PlayerScoreAggregate> scoreStorage = new GenericStorage<>();

    public static GenericStorage<Player> getPlayerStorage() {
        return playerStorage;
    }

    public static GenericStorage<PlayerScoreAggregate> getScoreStorage() {
        return scoreStorage;
    }
}
