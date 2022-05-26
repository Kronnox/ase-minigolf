package service;

import exception.InvalidPlayernameException;
import model.Player;
import model.Playername;
import repository.IPlayerRepository;

import java.util.List;
import java.util.UUID;

public class PlayerService {

    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player getById(UUID id) {
        return playerRepository.findById(id).orElse(null);
    }

    public void createPlayer(String name) throws InvalidPlayernameException {
        Playername playername = new Playername(name);
        Player player = new Player(playername);
        playerRepository.save(player);
    }
}
