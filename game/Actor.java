package rp.game;

import static rp.game.DiceRoll.roll3D6;

public class Actor {
    protected String name;
    private int health;
    protected int hl;
    private DiceRoll damage;

    public Actor(String name, int health, int hl, DiceRoll damage) {
        this.name = name;
        this.health = health;
        this.hl = hl;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHl() {
        return hl;
    }

    public int getDamage() {
        return damage.roll();
    }

    private boolean hit(int roll) {
        return roll <= getHl();
    }

    protected int rollAttack() {
        return roll3D6();
    }

    public void attack(Actor enemy) {
        System.out.println(getName() + " attacks " + enemy.getName() + "!");
        var roll = rollAttack();
        System.out.print("   Rolled: " + roll + " - HabilityLevel: " + getHl() + " - It's a ");

        if (hit(roll)) {
            System.out.println("HIT!");
            int damage = getDamage();
            enemy.takeDamage(damage);
            System.out.println("   " + enemy.getName() + " health " + enemy.getHealth());
        } else {
            System.out.println("MISS!");
        }
        System.out.println();
    }

    public void takeDamage(int damage) {
        health = health - damage;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
