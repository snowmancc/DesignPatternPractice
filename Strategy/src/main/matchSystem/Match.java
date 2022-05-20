package main.matchSystem;

import java.util.List;
import java.util.Map;

public interface Match {
    public  List<Individual> matchResult(Individual member, Map<Integer, Individual> individuals);
}
