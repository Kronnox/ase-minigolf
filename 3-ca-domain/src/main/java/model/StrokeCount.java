package model;

public class StrokeCount {

    private final int value;

    /**
     * Value object to store a count of strokes
     */
    public StrokeCount(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("The value has to be at least 1");
        }
        this.value = value;
    }

    /**
     * Get value
     * @return stroke count as int
     */
    public int toInt() {
        return value;
    }

    /**
     * Get value as String
     * @return stroke count as String
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrokeCount that = (StrokeCount) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
