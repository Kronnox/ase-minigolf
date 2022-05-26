package action;

import app.MinigolfApplication;
import model.Player;
import model.Score;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class PlayGameMenu extends AbstractMenu {

    public PlayGameMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        app.getPlayerService().getAll().forEach(this::printLeaderboardRow);
        if (!isGameFinished()) {
            printTurnInfo();
        }
    }

    private void printLeaderboardRow(Player player) {
        String scores = app.getScoreService().getAllForPlayer(player.getId()).stream()
                .map(Score::toString).collect(Collectors.joining(" "));
        int totalScore = app.getScoreService().getTotalForPlayer(player.getId());

        int nameColumnWidth = app.getPlayerService().getMaximumPlayernameLength();
        int scoreColumnWith = Math.max(1, app.getSession().getCurrentCourse().getTracks().size()*2-1);
        String format = "%-"+nameColumnWidth+"s | %-"+scoreColumnWith+"s | %s%n";
        System.out.format(format, player.getName(), scores, totalScore);
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
        return false; // TODO: app.getSession().getCurrentTrackIndex() >= app.getSession().getCurrentCourse().getTracks().size()
    }
}
