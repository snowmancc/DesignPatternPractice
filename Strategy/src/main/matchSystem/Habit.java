package main.matchSystem;

import java.util.ArrayList;
import java.util.List;

public class Habit {

    private String habitName;

    public Habit(String habitName) {
        this.habitName = habitName;
    }

    public String getHabit() {
        return habitName;
    }

    public void setHabit(String habitName) {
        this.habitName = habitName;
    }

    public boolean isSame(Habit other) {
        return this.habitName.equals(other.habitName);
    }

    public static List<Habit> genHabits(String... habits) {
        List<Habit> habitList = new ArrayList<>();
        for (String name : habits) {
            habitList.add(new Habit(name));
        }
        return habitList;
    }

    public static String printHabits(List<Habit> habits) {
        StringBuilder builder = new StringBuilder();
        habits.forEach((a) -> builder.append(a.habitName).append(", "));
        return builder.substring(0, builder.length() - 2);
    }

}
