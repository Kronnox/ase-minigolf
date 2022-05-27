package action;

import app.MinigolfApplication;
import model.*;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayGameMenu extends AbstractMenu {

    public PlayGameMenu(MinigolfApplication app) {
        super(app);
    }

    @Override
    public void show() {
        printLeaderboardRow(app.getSession().getCurrentCourse());
        app.getPlayerService().getAll().forEach(this::printLeaderboardRow);
        if (!isGameFinished()) {
            printTurnInfo();
        }
    }

    private void printLeaderboardRow(Course course) {
        printLeaderboardRow(
                "(Par)",
                course.getTracks().stream().map(Track::getPar).map(StrokeCount::toInt).toList(),
                course.getTracks().stream().map(Track::getPar).mapToInt(StrokeCount::toInt).sum()
        );
    }

    private void printLeaderboardRow(Player player) {
        printLeaderboardRow(
                player.getName().toString(),
                app.getScoreService().getAllForPlayer(player.getId()).stream().map(Score::toInt).toList(),
                app.getScoreService().getTotalForPlayer(player.getId())
        );
    }
    private void printLeaderboardRow(String label, List<Integer> scores, int totalScore) {
        String scoreString = scores.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(" "));

        int nameColumnWidth = Math.max(5, app.getPlayerService().getMaximumPlayernameLength());
        int scoreColumnWith = Math.max(1, app.getSession().getCurrentCourse().getTracks().size()*2-1);
        String format = "%-"+nameColumnWidth+"s | %-"+scoreColumnWith+"s | %s%n";
        System.out.format(format, label, scoreString, totalScore);
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
