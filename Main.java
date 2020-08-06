package rp;

import rp.game.DiceRoll;
import rp.game.Entity;
import rp.game.Hero;
import rp.game.Monster;

public class Main {
    private void Run(){
        Hero hero = new Hero("Allyson", 100, 10, new DiceRoll(1, 6));
        Monster monster = new Monster("Goblin", 30, 6, new DiceRoll(1,4,1));

        while(true){
            hero.Attack(monster);
            monster.Attack(hero);
            if (monster.isDead() || hero.isDead()){
                break;
            }
        }
        // Show results
        System.out.println("FINISHED ENCOUNTER!");
        printHealth(hero);
        printHealth(monster);
    }

    private void printHealth(Entity p){
        System.out.println(p.getName() + " " + p.getHealth());
    }

    public static void main(String[] args) {
        new Main().Run();
    }
}