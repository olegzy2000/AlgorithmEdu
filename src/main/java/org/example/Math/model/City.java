package org.example.Math.model;

public class City {
    int index;
    int x;
    int y;

    public City(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(City other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}