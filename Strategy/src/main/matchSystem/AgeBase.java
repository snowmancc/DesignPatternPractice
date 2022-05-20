package main.matchSystem;

import java.util.*;

public class AgeBase implements Match {

    @Override
    public List<Individual> matchResult(Individual member, Map<Integer, Individual> individuals) {
        individuals.remove(member.getID());
        Map<Integer, Set<Individual>> sort = new TreeMap<>();
        individuals.forEach((id, individual) -> {
            int memberCoord = member.getAge();
            int theOtherCoord = individual.getAge();
            int sub = Math.abs(memberCoord - theOtherCoord);
            Set<Individual> set = sort.containsKey(sub) ? sort.get(sub) : new TreeSet<>();
            set.add(individual);
            sort.put(sub, set);
        });
        Set<Map.Entry<Integer, Set<Individual>>> set = sort.entrySet();
        List<Individual> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Individual>> integerSetEntry : set) {
            result.addAll(integerSetEntry.getValue());
        }
        return result;
    }
}
