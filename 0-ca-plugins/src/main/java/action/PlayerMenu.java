package action;

import app.MinigolfApplication;
import model.Player;
import service.PlayerService;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class PlayerMenu extends AbstractMenu {

    public PlayerMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        System.out.println("Current players:");

        String playersAsString = app.getPlayerService().getAll().stream()
                .map(p -> p.getName().toString())
                .collect(Collectors.joining(", "));
        System.out.println(playersAsString.isBlank() ? "(None)" : playersAsString);
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        return new LinkedHashMap<>(){{
            put("Add Player", new AddPlayerAction(app));
            put("Start Game", new PlayGameMenu(app));
        }};
    }
}
