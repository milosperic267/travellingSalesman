package ch.bbw.travllingSalesman;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Outcome {
    private double length;
    private ArrayList<Coordinates> visitedCoordinates;

    public Outcome(ArrayList<Coordinates> visitedCoordinates, double length) {
        this.visitedCoordinates = visitedCoordinates;
        this.length = length;
    }

    @Override
    public String toString() {
        String string = "Length: " + length + "\nVisited Cities: ";
        for (Coordinates visitedCoordinate : visitedCoordinates) {
            string += visitedCoordinate + ", ";
        }
        return string;
    }
}
