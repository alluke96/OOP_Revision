package rp;

import java.util.*;

public class Exemplo {

    public static void main(String[] args) {
        Map<String, Integer> nomes = new TreeMap<>(Comparator.reverseOrder());
        nomes.put("Vinicius", 100);
        nomes.put("Eloisa", 50);
        nomes.put("Lucas", -30);
        nomes.put("Eloisa", 10);

        //System.out.println(nomes.get("Eloisa"));

        for (var entry : nomes.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

}
