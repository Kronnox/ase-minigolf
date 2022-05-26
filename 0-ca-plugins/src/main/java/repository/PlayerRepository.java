package repository;

import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Player> findById(UUID id) {
        return players.stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void save(Player player) {
        players.add(player);
    }
}
