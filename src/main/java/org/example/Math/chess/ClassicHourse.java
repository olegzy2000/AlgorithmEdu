package org.example.Math.chess;

import org.example.Math.chess.model.ChessSquare;

import java.util.*;
import java.util.stream.Collectors;

public class ClassicHourse {
    public static boolean start(int size,int xStartPosition,int yStartPosition){
        ChessSquare[][] matrix=new ChessSquare[size][size];
        initGraph(matrix);
        printMatrix(matrix);
        boolean result=resolve(matrix,matrix[xStartPosition][yStartPosition],1);
        printMatrix(matrix);
        return result;
    }

    private static void printMatrix(ChessSquare[][] matrix) {
       System.out.println();
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[i].length;j++){
               System.out.print(" ("+matrix[i][j].isVisited()+" "+matrix[i][j].getStepNumber()+") ");
           }
           System.out.println();
       }
    }

    private static boolean resolve(ChessSquare[][] matrix, ChessSquare current, int amountSteps) {
        current.setVisited(true);
        current.setStepNumber(amountSteps);
        if(amountSteps==matrix.length*matrix[0].length)
            return true;
        List<ChessSquare> chessSquares=current.getNeighbours()
                .stream()
                .filter(x-> !x.isVisited())
                .sorted(Comparator.comparingInt(a -> a.getNeighbours().size()))
                .toList();

        for(ChessSquare currentChessSquare : chessSquares) {
            if (!currentChessSquare.isVisited()) {
                if(resolve(matrix, currentChessSquare,amountSteps+1)){
                    return true;
                }
            }
        }
        current.setVisited(false);
        current.setStepNumber(-1);
        return false;
    }

    private static void initGraph(ChessSquare[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               matrix[i][j]=new ChessSquare();
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j].setxCoordinate(i);
                matrix[i][j].setyCoordinate(j);
                addNode(matrix, matrix[i][j], i + 2, j + 1);  // ↓→
                addNode(matrix, matrix[i][j], i + 2, j - 1);  // ↓←
                addNode(matrix, matrix[i][j], i - 2, j + 1);  // ↑→
                addNode(matrix, matrix[i][j], i - 2, j - 1);  // ↑←
                addNode(matrix, matrix[i][j], i + 1, j + 2);  // →↓
                addNode(matrix, matrix[i][j], i + 1, j - 2);  // ←↓
                addNode(matrix, matrix[i][j], i - 1, j + 2);  // →↑
                addNode(matrix, matrix[i][j], i - 1, j - 2);
            }
        }
    }

    private static void addNode(ChessSquare[][] matrix, ChessSquare currentNode, int i, int j) {
        if(i>=0 && i<matrix.length && j>=0 && j<matrix[i].length)
        {
            currentNode.getNeighbours().add(matrix[i][j]);
            matrix[i][j].getNeighbours().add(currentNode);
        }
    }
}
