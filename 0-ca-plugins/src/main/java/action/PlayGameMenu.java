package action;

import app.MinigolfApplication;
import leaderboard.Leaderboard;

import java.util.LinkedHashMap;

public class PlayGameMenu extends AbstractMenu {

    public PlayGameMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        new Leaderboard(app).print();
        if (!isGameFinished()) {
            printTurnInfo();
        }
    }

    private void printTurnInfo() {
        System.out.println("-----------------------------------------------"); // divider
        System.out.printf(
                "Playing: %s | Hole %s | Stroke %s / %s\n",
                app.getSession().getCurrentPlayer().getName(),
                app.getSession().getCurrentTrackIndex(),
                app.getSession().getCurrentScore(),
                app.getSession().getCurrentCourse().getMaxStrokes()
        );
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        if (isGameFinished()) {
            return new LinkedHashMap<>(){{
                put("Exit Game", new ExitApplicationAction());
            }};
        }

        return new LinkedHashMap<>(){{
            put("Add Stroke", new AddStrokeAction(app));
            put("Complete Turn", new CompleteTurnAction(app));
            put("Surrender Hole", new SurrenderHoleAction(app));
        }};
    }

    private boolean isGameFinished() {
        return app.getSession().getCurrentTrackIndex() >= app.getSession().getCurrentCourse().getTracks().size();
    }
}
