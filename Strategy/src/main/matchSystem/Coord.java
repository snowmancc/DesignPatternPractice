package main.matchSystem;

import java.awt.geom.Point2D;

public class Coord {
    private double x;
    private double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Coord targetCoord) {
        return Point2D.distance(x, y, targetCoord.x, targetCoord.y);
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
