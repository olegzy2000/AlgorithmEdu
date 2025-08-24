package org.example.Math.chess;

import org.example.Math.chess.model.ChessSquare;

import java.util.Comparator;

public class ClassicHourse {
    private static int amountSteps;
    public static void start(int size,int xStartPosition,int yStartPosition){
        ChessSquare[][] matrix=new ChessSquare[size][size];
        initGraph(matrix);
        amountSteps=0;
        resolve(matrix,xStartPosition,yStartPosition);
    }

    private static void resolve(ChessSquare[][] matrix, int xStartPosition, int yStartPosition) {
        if(matrix[xStartPosition][yStartPosition].isVisited())
            return;
        ChessSquare chessSquare=matrix[xStartPosition][yStartPosition].getNeighbours()
                .stream()
                .filter(x-> !x.isVisited())
                .max(Comparator.comparingInt(a -> a.getNeighbours().size()))
                .orElse(null);


    }

    private static void initGraph(ChessSquare[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j].setxCoordinate(i);
                matrix[i][j].setyCoordinate(j);
                addNode(matrix,matrix[i][j],i+2,j+1);
                addNode(matrix,matrix[i][j],i+2,j-1);
                addNode(matrix,matrix[i][j],i-2,j+1);
                addNode(matrix,matrix[i][j],i-2,j-1);
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
