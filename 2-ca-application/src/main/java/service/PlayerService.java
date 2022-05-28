package service;

import exception.InvalidPlayernameException;
import model.Player;
import model.Playername;
import repository.IPlayerRepository;

import java.util.List;

public class PlayerService {

    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getFirst() {
        if (playerRepository.findAll().size() == 0) {
            return null;
        }
        return playerRepository.findAll().get(0);
    }

    public boolean isFirst(Player player) {
        return playerRepository.findAll().indexOf(player) == 0;
    }

    public Player getPlayerFollowing(Player player) {
        int i = playerRepository.findAll().indexOf(player);
        if (i == -1) {
            throw new IllegalArgumentException("Player not found in repository");
        }

        i = i+1 >= playerRepository.findAll().size() ? 0 : i+1;

        return playerRepository.findAll().get(i);
    }

    public void createPlayer(String name) throws InvalidPlayernameException {
        Playername playername = new Playername(name);
        Player player = new Player(playername);
        playerRepository.save(player);
    }

    public int getMaximumPlayernameLength() {
        return playerRepository.getMaximumPlayernameLength();
    }
}
