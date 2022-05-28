package app;

import action.MainMenu;
import manager.SessionManager;
import repository.PlayerRepository;
import repository.PlayerScoreRepository;
import service.PlayerService;
import service.ScoreService;

public class MinigolfApplication {

    private final PlayerService playerService;
    private final ScoreService scoreService;

    private final SessionManager session;

    public MinigolfApplication() {
        playerService = new PlayerService(new PlayerRepository());
        scoreService = new ScoreService((new PlayerScoreRepository()));

        session = new SessionManager(playerService, scoreService);

        new MainMenu(this).execute();
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public ScoreService getScoreService() {
        return scoreService;
    }

    public SessionManager getSession() {
        return session;
    }
}
