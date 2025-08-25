package org.example.Math.chess;

import org.example.Math.chess.model.ChessSquare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassicHourse {
    private static int amountSteps=0;
    public static void start(int size,int xStartPosition,int yStartPosition){
        ChessSquare[][] matrix=new ChessSquare[size][size];
        initGraph(matrix);
        printMatrix(matrix);
        amountSteps=1;
        resolve(matrix,matrix[xStartPosition][yStartPosition]);
        System.out.println(amountSteps);
        printMatrix(matrix);
    }

    private static void printMatrix(ChessSquare[][] matrix) {
       System.out.println();
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[i].length;j++){
               System.out.print(matrix[i][j].isVisited()+" ");
           }
           System.out.println();
       }
    }

    private static void resolve(ChessSquare[][] matrix, ChessSquare current) {
        printMatrix(matrix);
        current.setIsVisited(true);
        if(amountSteps==64)
            return;
        amountSteps++;
        Set<ChessSquare> chessSquares=current.getNeighbours()
                .stream()
                .filter(x-> !x.isVisited())
                .sorted(Comparator.comparingInt(a -> a.getNeighbours().size()))
                .collect(Collectors.toSet());
        if((chessSquares==null || chessSquares.isEmpty())&& amountSteps<64){
            amountSteps--;
            current.setIsVisited(false);
            return;
        }
        if(chessSquares.iterator().hasNext()) {
            ChessSquare currentChessSquare = chessSquares.iterator().next();
            if (!currentChessSquare.isVisited()) {
                resolve(matrix, currentChessSquare);
            }
        }
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
