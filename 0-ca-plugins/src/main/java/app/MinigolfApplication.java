package app;

import action.MainMenu;
import manager.SessionManager;
import repository.PlayerRepository;
import service.PlayerService;

public class MinigolfApplication {

    private final PlayerService playerService;

    private final SessionManager session;

    public MinigolfApplication() {
        playerService = new PlayerService(new PlayerRepository());

        session = new SessionManager(playerService);

        new MainMenu(this).execute();
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public SessionManager getSession() {
        return session;
    }
}
