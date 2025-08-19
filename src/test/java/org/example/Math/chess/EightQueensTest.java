package org.example.Math.chess;

import org.example.Math.chess.model.ResultCoordinates;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class EightQueensTest {

    @Test
    public void getCountOfPossiblePosition() {
        HashSet<List<ResultCoordinates>> list=EightQueens.getListPositionOfEightQueens();
        System.out.println(list.size());
        for(List<ResultCoordinates>objectList:list) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println(objectList.size());
            System.out.println(objectList);
            System.out.println("------------------------------------------------------------------------");
        }
    }
}