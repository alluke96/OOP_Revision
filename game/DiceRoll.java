package rp.game;

import java.util.Random;

public class DiceRoll {
    private static final Random RND = new Random();

    private int number;
    private int faces;
    private int bonus;

    public DiceRoll(int number, int faces, int bonus) {
        this.number = number;
        this.faces = faces;
        this.bonus = bonus;
    }

    public DiceRoll(int number, int faces) {
        this(number, faces, 0);
    }

    public DiceRoll(int faces) {
        this(1, faces);
    }

    public int roll() {
        int total = 0;
        for (int i = 0; i < number; i++) {
            int roll = RND.nextInt(faces) + 1;
            total += roll;
        }
        return total + bonus;
    }

    public static int roll3D6() {
        return new DiceRoll(3, 6).roll();
    }
}
