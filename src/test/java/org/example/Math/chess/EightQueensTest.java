package org.example.Math.chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class EightQueensTest {

    @Test
    public void getCountOfPossiblePosition() {
        System.out.println(EightQueens.getCountOfPossiblePosition(8,8));
    }
}