package rp.game;

public class Hero extends Entity {

    public Hero(String name, int health, int habilityLevel, DiceRoll damage) {
        super(name, health, habilityLevel, damage);
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("The name cannot be null!");
        super.setName(name);
    }

    public void setHabilityLevel(int habilityLevel){
        super.setHabilityLevel(habilityLevel);
    }
}
