package main.matchSystem;

import java.util.*;

public class HabitBase implements Match {
    @Override
    public List<Individual> matchResult(Individual member, Map<Integer, Individual> individuals) {
        individuals.remove(member.getID());
        Map<Integer, Set<Individual>> sort = new TreeMap<>(Comparator.reverseOrder());
        individuals.forEach((id, individual) -> {
            List<Habit> memberHabits = member.getHabits();
            List<Habit> theOtherHabits = individual.getHabits();
            int count = 0;
            for (Habit base : memberHabits) {
                for (Habit other : theOtherHabits) {
                    if (base.isSame(other)) {
                        count++;
                    }
                }
            }
            Set<Individual> set = sort.containsKey(count) ? sort.get(count) : new TreeSet<>();
            set.add(individual);
            sort.put(count, set);
        });
        Set<Map.Entry<Integer, Set<Individual>>> set = sort.entrySet();
        List<Individual> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Individual>> integerSetEntry : set) {
            result.addAll(integerSetEntry.getValue());
        }
        return result;
    }
}
