package leaderboard;

import app.MinigolfApplication;
import model.*;
import repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    private final MinigolfApplication app;

    private String format;

    public Leaderboard(MinigolfApplication app) {
        this.app = app;

        initializeFormat();
    }

    private void initializeFormat() {
        StringBuilder format = new StringBuilder();

        // Label section
        int nameColumnWidth = Math.max(5, app.getPlayerService().getMaximumPlayernameLength());
        format.append("%-").append(nameColumnWidth).append("s |");

        // Score section
        int scoreColumnWidth = app.getSession().getCurrentCourse().getMaxStrokes().toString().length();

        for (int i = 0; i < app.getSession().getCurrentCourse().getTracks().size(); i++) {
            format.append(" %").append(scoreColumnWidth).append("s");
        }

        // Total score section
        format.append(" | %s%n");

        // Final print out
        this.format = format.toString();
    }

    public void print() {
        printLeaderboardRowFor(app.getSession().getCurrentCourse());
        new PlayerRepository().findAll().forEach(this::printLeaderboardRowFor);
    }

    private void printLeaderboardRowFor(Course course) {
        printLeaderboardRow(
                "(Par)",
                course.getTracks().stream().map(Track::getPar).map(StrokeCount::toInt).toList()
        );
    }

    private void printLeaderboardRowFor(Player player) {
        printLeaderboardRow(
                player.getName().toString(),
                app.getScoreService().getAllForPlayer(player).stream().map(Score::toInt).toList()
        );
    }
    private void printLeaderboardRow(String label, List<Integer> scores) {
        List<Object> parameters = new ArrayList<>();

        // Label section
        parameters.add(label);

        // Score section
        int totalScore = 0;
        for (int i = 0; i < app.getSession().getCurrentCourse().getTracks().size(); i++) {
            if (i >= scores.size()) {
                parameters.add("-");
                continue;
            }
            int score = scores.get(i);
            parameters.add(score);
            totalScore += score;
        }

        // Total score section
        parameters.add(totalScore);

        // Final print out
        System.out.format(format, parameters.toArray());
    }
}
