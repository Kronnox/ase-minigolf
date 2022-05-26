package model;

public class Score {

    private final int max;
    private int value;

    /**
     * Value object to store the current score
     * @param max the maximum amount of allowed strokes
     */
    public Score(int max) {
        if (max < 1) {
            throw new IllegalArgumentException("The maximum score has to be at least 1");
        }
        int limit = Integer.MAX_VALUE-2;
        if (max > limit) {
            throw new IllegalArgumentException("The maximum score cannot be greater than "+limit);
        }
        this.max = max;
        this.value = 1;
    }

    /**
     * Get value
     * @return score as int
     */
    public int toInt() {
        return value;
    }

    /**
     * Get value as String
     * @return score as String
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Increments the score. In case it reaches the maximum add two to the score
     * @return true if reached the maximum
     */
    public boolean increment() {
        if (value >= max) {
            setToMax();
            return true;
        }
        value++;
        return false;
    }

    /**
     * Sets the score to it's maximum value plus two
     */
    public void setToMax() {
        value = max + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (max != score.max) return false;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        int result = max;
        result = 31 * result + value;
        return result;
    }
}
