package repository;

import model.Player;
import model.Playername;

import java.util.*;

public class PlayerRepository implements IPlayerRepository {

    private final List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public void save(Player player) {
        players.add(player);
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
