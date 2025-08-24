package org.example.Math.chess.model;

import java.util.List;
import java.util.Set;

public class ChessSquare {
    private int xCoordinate;
    private int yCoordinate;

    private boolean isVisited=false
    private Set<ChessSquare> neighbours;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Set<ChessSquare> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Set<ChessSquare> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
