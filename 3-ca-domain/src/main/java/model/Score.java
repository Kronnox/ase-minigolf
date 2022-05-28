package model;

import java.util.Objects;

public class Score {

    private final StrokeCount maxScore;
    private StrokeCount score;

    /**
     * Aggregate to store a count of strokes and maximum allowed strokes
     * @param maxScore the maximum amount of allowed strokes
     */
    public Score(StrokeCount maxScore) {
        int limit = Integer.MAX_VALUE-2;
        if (maxScore.toInt() > limit) {
            throw new IllegalArgumentException("The maximum score cannot be greater than "+limit);
        }
        this.maxScore = maxScore;
        this.score = new StrokeCount(1);
    }

    /**
     * Get value
     * @return stroke count as int
     */
    public int toInt() {
        return score.toInt();
    }

    /**
     * Get value as String
     * @return stroke count as String
     */
    @Override
    public String toString() {
        return score.toString();
    }

    /**
     * Increments the stroke count. In case it reaches the maximum add two
     * @return true if reached the maximum
     */
    public boolean increment() {
        if (score.toInt() >= maxScore.toInt()) {
            setToMax();
            return true;
        }
        score = new StrokeCount(score.toInt()+1);
        return false;
    }

    /**
     * Sets the stroke count to it's maximum value plus two
     */
    public void setToMax() {
        score = new StrokeCount(maxScore.toInt()+2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score1 = (Score) o;

        if (!Objects.equals(maxScore, score1.maxScore)) return false;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        int result = maxScore != null ? maxScore.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
