package manager;

import model.Course;
import model.Player;
import model.Score;
import service.PlayerService;
import service.ScoreService;

public class SessionManager {

    private final PlayerService playerService;
    private final ScoreService scoreService;

    private Course currentCourse;
    private int currentTrackIndex;

    private Player currentPlayer;
    private Score currentScore;

    public SessionManager(PlayerService playerService, ScoreService scoreService) {
        this.playerService = playerService;
        this.scoreService = scoreService;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
        this.currentTrackIndex = 0;
    }

    public Player getCurrentPlayer() {
        if (currentPlayer == null) {
            currentPlayer = playerService.getFirst();
            currentScore = new Score(getCurrentCourse().getMaxStrokes());
        }
        return currentPlayer;
    }

    public Score getCurrentScore() {
        return currentScore;
    }

    public void goToNextPlayer() {
        scoreService.addToPlayer(currentPlayer.getId(), currentScore);

        currentPlayer = playerService.getPlayerFollowing(currentPlayer);
        if (playerService.isFirst(currentPlayer)) {
            goToNextTrack();
        }

        currentScore = new Score(getCurrentCourse().getMaxStrokes());
    }

    public int getCurrentTrackIndex() {
        return currentTrackIndex;
    }

    private void goToNextTrack() {
        currentTrackIndex++;
    }
}
