package manager;

import model.Course;
import model.Player;
import service.PlayerService;

public class SessionManager {

    private final PlayerService playerService;

    private Course currentCourse;
    private int currentTrackIndex;

    private Player currentPlayer;

    public SessionManager(PlayerService playerService) {
        this.playerService = playerService;
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
        }
        return currentPlayer;
    }

    public void goToNextPlayer() {
        currentPlayer = playerService.getPlayerFollowing(currentPlayer);
    }

    public int getCurrentTrackIndex() {
        return currentTrackIndex;
    }

    public void goToNextTrack() {
        currentTrackIndex++;
    }
}
