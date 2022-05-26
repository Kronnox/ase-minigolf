package action;

import app.MinigolfApplication;

import java.util.LinkedHashMap;

public class MainMenu extends AbstractMenu {

    public MainMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        System.out.println("Welcome to Minigolf!");
        System.out.println("Choose one of the following options by typing the corresponding number.");
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        return new LinkedHashMap<>(){{
            put("Play Game", new StartGameMenu(app));
            put("Exit", new ExitApplicationAction());
        }};
    }
}
