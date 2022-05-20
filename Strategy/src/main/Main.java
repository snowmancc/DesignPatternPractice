package main;

import main.matchSystem.*;

public class Main {

    public static void main(String[] args) {
        Individual me = new Individual();
        me.setAge(20);
        me.setGender(Gender.MALE);
        me.setIntro("me me");
        me.setHabits(Habit.genHabits("sport", "read", "cookie"));
        me.setCoord(new Coord(1, 1));

        Individual p1 = new Individual();
        p1.setAge(30);
        p1.setGender(Gender.MALE);
        p1.setIntro("p1 p1");
        p1.setHabits(Habit.genHabits("movie", "sport"));
        p1.setCoord(new Coord(6, 6));

        Individual p2 = new Individual();
        p2.setAge(18);
        p2.setGender(Gender.MALE);
        p2.setIntro("p1 p1");
        p2.setHabits(Habit.genHabits("sport"));
        p2.setCoord(new Coord(2, 3));

        Individual p3 = new Individual();
        p3.setAge(22);
        p3.setGender(Gender.FEMALE);
        p3.setIntro("p3 p3");
        p3.setHabits(Habit.genHabits("sport"));
        p3.setCoord(new Coord(1, 3));

        MatchSystem sys = new MatchSystem();
        sys.addMember(p2);
        sys.addMember(p3);
        sys.addMember(p1);
        sys.addMember(me);

        System.out.println("Me: " + me);
        System.out.println("--match-- ");
        sys.match(me, new HabitBase());
        System.out.println("--match reserve-- ");
        sys.matchReverse(me, new HabitBase());
    }
}
