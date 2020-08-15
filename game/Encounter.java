package rp.game;

import java.util.*;
import java.util.stream.Collectors;

public class Encounter {
    private List<Actor> group1;
    private List<Actor> group2;

    public Encounter(List<? extends Actor> group1, List<? extends Actor> group2) {
        this.group1 = new ArrayList<>(group1);
        this.group2 = new ArrayList<>(group2);
    }

    public void battle() {
        System.out.println("ENCOUNTER STARTED!!!");
        print(group1);
        System.out.println();
        print(group2);

        int turn = 1;
        do
        {
            System.out.println();
            System.out.println("TURN " + turn);
            System.out.println("---------");
            processTurn();
            turn = turn + 1;
            System.out.println();

        } while (!ended());
        System.out.println("FINISHED ENCOUNTER!!!");
        print(group1);
        System.out.println();
        print(group2);

    }

    private void print(List<Actor> group) {
        group.stream().forEach(a->
                System.out.printf("Name: %s HabilityLevel: %d Health: %d%n",
                        a.getName(), a.getHl(), a.getHealth())
        );
    }

    private boolean ended() {
        return isDead(group1) || isDead(group2);
    }

    private boolean isDead(List<Actor> group) {
        return group.stream().allMatch(Actor::isDead);
    }

    private void processTurn() {
        var battleOrder = rollInitiative();

        for (var actor : battleOrder) {
            if (actor.isDead()) continue;
            List<Actor> enemies = getAlive(
                    group1.contains(actor) ? group2 : group1
            );
            if (enemies.size() == 0) break;

            Actor enemy = random(enemies);
            actor.attack(enemy);
        }
    }

    private Actor random(List<Actor> enemies) {
        DiceRoll dr = new DiceRoll(1, enemies.size(), -1);
        return enemies.get(dr.roll());
    }

    private List<Actor> rollInitiative() {
        var initiatives = new TreeMap<Integer, List<Actor>>(Comparator.reverseOrder());
        rollInitiative(getAlive(group1), initiatives);
        rollInitiative(getAlive(group2), initiatives);
        printInitiatives(initiatives);

        var result = new ArrayList<Actor>();
        for (var actors : initiatives.values()) {
            result.addAll(actors);
        }
        return result;
    }

    private List<Actor> getAlive(List<Actor> group) {
        return group.stream()
                .filter(a -> !a.isDead())
                .collect(Collectors.toList());
    }

    private void printInitiatives(TreeMap<Integer, List<Actor>> initiatives) {
        for (var entry : initiatives.entrySet()) {
            var names = entry.getValue().stream()
                    .map(Actor::getName)
                    .collect(Collectors.toList());

            System.out.println(entry.getKey() + ": " + names);
        }
    }

    private void rollInitiative(List<Actor> group, TreeMap<Integer, List<Actor>> initiatives) {
        DiceRoll d20 = new DiceRoll(20);
        for (Actor a : group) {
            int initiative = d20.roll();
            if (!initiatives.containsKey(initiative)) {
                initiatives.put(initiative, new ArrayList<>());
            }
            initiatives.get(initiative).add(a);
        }
    }
}
