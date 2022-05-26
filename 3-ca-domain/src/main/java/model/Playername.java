package model;

import exception.InvalidPlayernameException;

import java.util.Objects;

public class Playername {

    private final String value;

    /**
     * Value object to store a playername
     * @param playername value that is at least 1 and a maximum of 15 characters long
     * @throws InvalidPlayernameException in case of invalid value parameters
     */
    public Playername(String playername) throws InvalidPlayernameException {

        if (playername.length() < 1) {
            throw new InvalidPlayernameException("The playername needs to be at least 1 character long");
        }
        if (playername.length() > 15) {
            throw new InvalidPlayernameException("The playername cannot be longer than 15 characters");
        }

        this.value = playername;
    }

    /**
     * Gets the playername value
     * @return value as String
     */
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playername playername = (Playername) o;
        return Objects.equals(value, playername.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
