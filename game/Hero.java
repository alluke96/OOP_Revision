package rp.game;

import java.util.Scanner;

public class Hero extends Actor {
    public Hero(String name, int health, int hl, DiceRoll damage) {
        super(name, health, hl, damage);
    }

    public Hero() {
        super("Damodar", 50, 10, new DiceRoll(1, 6));
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be null!");
        }
        this.name = name;
    }

    public void setHl(int hl) {
        this.hl = hl;
    }
}
