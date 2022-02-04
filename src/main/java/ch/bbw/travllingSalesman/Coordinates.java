package ch.bbw.travllingSalesman;

import lombok.Data;

@Data
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Coordinates coordinates){
        int newX = coordinates.x - x;
        int newY = coordinates.y - y;
        return Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
    }

    @Override
    public String toString() {
        return "{x: " + x + ", y: " + y + "}";
    }
}
