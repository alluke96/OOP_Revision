package rp.game;

import static rp.game.DiceRoll.Roll3D6;

public class Entity {
    private String name;
    private int health;
    private int habilityLevel;
    private DiceRoll damage;

    public Entity(String name, int health, int habilityLevel, DiceRoll damage) {
        this.name = name;
        this.health = health;
        this.habilityLevel = habilityLevel;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getHabilityLevel() {
        return habilityLevel;
    }

    public void setHabilityLevel(int habilityLevel) {
        this.habilityLevel = habilityLevel;
    }

    public void Attack(Entity enemy){
        System.out.println(getName() + " attacks:");
        int roll = Roll3D6();
        System.out.println("Rolled " + roll + " hability level " + getHabilityLevel() + " ");
        if (roll <= getHabilityLevel()){
            System.out.println("HIT!");
            int damage = getDamage();
            TakeDamage(damage);
            System.out.println("   " + getName() + " health " + getHealth());
        } else {
            System.out.println("MISS!");
        }
        System.out.println();
    }

    public int getDamage(){
        return damage.Roll();
    }

    public void TakeDamage(int damage) {
        health -= damage;
    }

    public boolean isDead(){
        return health <= 0;
    }
}