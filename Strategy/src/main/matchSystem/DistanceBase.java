package main.matchSystem;

import java.util.*;

public class DistanceBase implements Match {

    @Override
    public List<Individual> matchResult(Individual member, Map<Integer, Individual> individuals) {
        individuals.remove(member.getID());
        Map<Double, Set<Individual>> sort = new TreeMap<>();
        individuals.forEach((id, individual) -> {
            Coord memberCoord = member.getCoord();
            Coord theOtherCoord = individual.getCoord();
            Double line = memberCoord.distance(theOtherCoord);
            Set<Individual> set = sort.containsKey(line) ? sort.get(line) : new TreeSet<>();
            set.add(individual);
            sort.put(line, set);
        });
        Set<Map.Entry<Double, Set<Individual>>> set = sort.entrySet();
        List<Individual> result = new ArrayList<>();
        for (Map.Entry<Double, Set<Individual>> doubleSetEntry : set) {
            result.addAll(doubleSetEntry.getValue());
        }
        return result;
    }
}
