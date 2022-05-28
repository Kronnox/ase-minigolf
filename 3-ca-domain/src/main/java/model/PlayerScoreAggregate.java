package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Connects a player to it's scores
 */
public class PlayerScoreAggregate {

    private final Player player;
    private final List<Score> scores = new ArrayList<>();

    public PlayerScoreAggregate(Player player) {
        this.player = player;
    }

    /**
     * Gets the linked player instance
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the scores of a player
     * @return read-only list of scores
     */
    public List<Score> getScores() {
        // return read-only copy
        return new ArrayList<>(scores);
    }

    /**
     * Adds a single score
     * @param score score
     */
    public void addScore(Score score) {
        scores.add(score);
    }
}
