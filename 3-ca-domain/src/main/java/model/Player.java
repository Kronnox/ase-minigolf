package model;

import java.util.UUID;

public class Player {

    private final UUID id;
    private final Playername name;

    public Player(UUID id, Playername name) {
        this.id = id;
        this.name = name;
    }

    public Player(Playername name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Playername getName() {
        return name;
    }
}
