package org.example.Math.chess.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChessSquare {
    private int xCoordinate;
    private int yCoordinate;

    private boolean isVisited=false;
    private int stepNumber=-1;

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
    public boolean isVisited() {
        return isVisited;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    private Set<ChessSquare> neighbours=new HashSet<>();

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


}
