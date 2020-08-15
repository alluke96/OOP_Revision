package rp;

import rp.game.*;

import java.util.ArrayList;

public class Main {
    public void printHealth(Actor p) {
        System.out.println("  " + p.getName() + " health " + p.getHealth());
    }

    void run() {
        var heroes = new ArrayList<Hero>();
        heroes.add(new Hero("Allyson", 100, 12, new DiceRoll(1, 12, 1)));
        heroes.add(new Hero("Victor", 80, 15, new DiceRoll(1, 12, 1)));
        heroes.add(new Hero("Lucas", 150, 8, new DiceRoll(1, 12, 1)));
        heroes.add(new Hero("Matheus", 100, 10, new DiceRoll(1, 18, 2)));

        var monsters = new ArrayList<Monster>();
        var hitDice = new DiceRoll(3, 4, 2);
        var hlDice= new DiceRoll(1, 6, 6);
        for (int i = 1; i <= 6; i++) {
            monsters.add(new Monster("Goblin" + i,
                    hitDice.roll(), hlDice.roll(),
                    new DiceRoll(1, 4, 1))
            );
        }

        Encounter encounter = new Encounter(heroes, monsters);
        encounter.battle();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
