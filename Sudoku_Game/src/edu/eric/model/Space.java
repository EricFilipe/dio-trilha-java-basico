package edu.eric.model;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private List<String> spaces;
    private static boolean occupied;

    public Space() {
        this.spaces = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            spaces.add(" ");
        }
    }

    public List<String> getSpaces() {
        return spaces;
    }

    public static boolean isOccupied() {
        return occupied;
    }

    public static void setOccupied(boolean occupied) {
        Space.occupied = occupied;
    }

    @Override
    public String toString() {
        return "spaces=" + spaces;
    }
}
