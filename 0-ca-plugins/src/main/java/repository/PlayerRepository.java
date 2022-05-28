package repository;

import model.Player;
import model.Playername;
import storage.GenericStorage;
import storage.StorageManager;

import java.util.*;

public class PlayerRepository implements IPlayerRepository {

    private final GenericStorage<Player> players = StorageManager.getPlayerStorage();
    @Override
    public List<Player> findAll() {
        return players.retrieve();
    }

    @Override
    public void save(Player player) {
        players.store(player);
    }

    @Override
    public int getMaximumPlayernameLength() {
        return findAll().stream()
                .map(Player::getName)
                .map(Playername::toString)
                .max(Comparator.comparingInt(String::length))
                .orElse("")
                .length();
    }
}
