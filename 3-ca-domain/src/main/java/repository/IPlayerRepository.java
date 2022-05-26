package repository;

import model.Player;
import model.Track;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPlayerRepository {

    List<Player> findAll();

    Optional<Player> findById(UUID id);

    void save(Player player);
}
