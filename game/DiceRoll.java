package rp.game;

import java.util.Random;

public class DiceRoll {
    private int number;
    private int faces;
    private int bonus;

    private static final Random RND = new Random();

    public DiceRoll(int number, int faces, int bonus) {
        this.number = number;
        this.faces = faces;
        this.bonus = bonus;
    }

    public DiceRoll(int number, int faces){
        this(number, faces, 0);
    }

    public int Roll(){
        int total = 0;
        for (int i=0; i< number; i++){
            int roll = RND.nextInt(faces) + 1;
            total += roll;
        }
        return total + bonus;
    }

//    private int Roll3D6() {
//        int d1 = RND.nextInt(6) + 1;
//        int d2 = RND.nextInt(6) + 1;
//        int d3 = RND.nextInt(6) + 1;
//        return d1 + d2 + d3;
//    }
    public static int Roll3D6(){
        return new DiceRoll(1,6).Roll();
    }
}
