package app;

import action.MainMenu;
import repository.PlayerRepository;
import service.PlayerService;

public class MinigolfApplication {

    private final PlayerService playerService;

    public MinigolfApplication() {
        playerService = new PlayerService(new PlayerRepository());

        new MainMenu(this).execute();
    }

    public PlayerService getPlayerService() {
        return playerService;
    }
}
