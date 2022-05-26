package action;

import app.MinigolfApplication;

import java.util.LinkedHashMap;

public class PlayGameMenu extends AbstractMenu {

    public PlayGameMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        app.getPlayerService().getAll().forEach(player -> {
            System.out.printf("%s\t", player.getName());
            System.out.println();
        });
        System.out.println("-----------------------------------------------"); // divider
        System.out.printf(
                "Playing: %s | Stroke %s / %s\n",
                app.getSession().getCurrentPlayer().getName(),
                "X",
                app.getSession().getCurrentCourse().getMaxStrokes()
                );
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        return new LinkedHashMap<>(){{
            put("Add Stroke", new ExitApplicationAction());
            put("Surrender Hole", new ExitApplicationAction());
        }};
    }
}
