package main.matchSystem;

import java.util.List;

public class Individual implements Comparable<Individual>{

    private int ID;

    private Gender gender;

    private int age;

    private String intro;

    private List<Habit> habits;

    private Coord coord;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "ID:" + ID + ", gender:" + gender + ", age:" + age
                + ", intro:" + intro + ", habits:" + Habit.printHabits(habits)
                + ", coord:" + coord;
    }

    @Override
    public int compareTo(Individual o) {
        return this.ID - o.ID;
    }
}
