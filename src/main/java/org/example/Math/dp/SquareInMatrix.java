package org.example.Math.dp;

public class SquareInMatrix {
    public static void start(String[] args) {
        int matrix[][]= new int[5][5];
        matrix[0]=new int[]{0,0,1,0,0};
        matrix[1]=new int[]{0,0,0,1,0};
        matrix[2]=new int[]{1,0,1,1,0};
        matrix[3]=new int[]{0,1,1,1,0};
        matrix[4]=new int[]{0,1,0,0,1};
        startAlgorithm(matrix);
    }

    private static void startAlgorithm(int[][] matrix) {
        int squadSizeMatrix[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i< squadSizeMatrix.length;i++){
            for(int j=0;j<squadSizeMatrix[i].length;j++){
                squadSizeMatrix[i][j]=0;
            }
        }
        int maxSquad=0;

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0){
                        squadSizeMatrix[i][j]=1;
                    }
                    else {
                        squadSizeMatrix[i][j] = getMinValue(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1])+1;
                    }
                    if(squadSizeMatrix[i][j]>maxSquad){
                        maxSquad=squadSizeMatrix[i][j];
                    }
                }
            }
        }

        for(int i=0; i< squadSizeMatrix.length; i++){
            for(int j=0; j<squadSizeMatrix[i].length; j++){
                System.out.print(squadSizeMatrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(maxSquad*maxSquad);
    }

    public static int getMinValue(int first, int second, int third) {
        int currentMin = Math.min(first,second);
        return Math.min(currentMin,third);
    }

}
