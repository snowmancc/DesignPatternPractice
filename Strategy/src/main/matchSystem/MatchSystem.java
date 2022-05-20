package main.matchSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchSystem {

    private Map<Integer, Individual> individuals;
    private int memberCount;

    public MatchSystem() {
        this.individuals = new HashMap<>();
    }

    public void addMember(Individual individual) {
        individual.setID(++memberCount);
        individuals.put(individual.getID(), individual);
    }

    public void match(Individual user, Match matchFunction) {
        System.out.println("match target: " + matchFunction.matchResult(user, individuals).get(0).toString());
    }

    public void matchReverse(Individual user, Match matchFunction) {
        List<Individual> result = matchFunction.matchResult(user, individuals);
        int last = result.size();
        System.out.println("match target: " + result.get(last - 1).toString());
    }
}
