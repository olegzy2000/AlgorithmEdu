package org.example.Math;

import org.example.Math.model.PairCoordinate;
import org.example.Math.model.VertexForMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmBsfMatrix {
    public static int bsfStartWithMap(int[][] map,PairCoordinate startPoint,PairCoordinate endPoint){
        List<List<VertexForMatrix>>vertexMap=new ArrayList<>();
        for(int i=0;i<map.length;i++){
            List<VertexForMatrix>rowList=new ArrayList<>();
            for(int j=0;j<map[i].length;j++){
                rowList.add(new VertexForMatrix());
            }
            vertexMap.add(rowList);
        }
        for(int i=0;i<vertexMap.size();i++){
            for(int j=0;j<vertexMap.get(i).size();j++){
                VertexForMatrix currentVertex=vertexMap.get(i).get(j);
                initVertexNeighbour(currentVertex,i,j,vertexMap);
            }
        }
        int result=bsfForMatrix(vertexMap,startPoint,endPoint);
        return result;
    }

    private static int bsfForMatrix(List<List<VertexForMatrix>> vertexMap, PairCoordinate startPoint, PairCoordinate finishPoint) {
        LinkedList<VertexForMatrix> vertexForMatrixLinkedList=new LinkedList<>();
        VertexForMatrix startVertex=vertexMap.get(startPoint.getX()).get(startPoint.getY());
        startVertex.setDistanceToStart(0);
        vertexForMatrixLinkedList.add(vertexMap.get(startPoint.getX()).get(startPoint.getY()));
        while (!vertexForMatrixLinkedList.isEmpty()){
            VertexForMatrix vertex=vertexForMatrixLinkedList.removeFirst();
            vertex.setVisited(true);
            for(int i=0;i<vertex.getIndexesOfNeighbourVertex().size();i++){
                PairCoordinate currentCoordinate=vertex.getIndexesOfNeighbourVertex().get(i);
                VertexForMatrix vertexForMatrix=vertexMap.get(currentCoordinate.getX()).get(currentCoordinate.getY());
                if(!vertexForMatrix.isVisited()){
                    vertexForMatrix.setVisited(true);
                    vertexForMatrix.setDistanceToStart(vertex.getDistanceToStart()+1);
                    vertexForMatrixLinkedList.add(vertexForMatrix);
                }
            }
            VertexForMatrix finishVertex=vertexMap.get(finishPoint.getX()).get(finishPoint.getY());
            if(finishVertex.isVisited()){
                return finishVertex.getDistanceToStart();
            }
        }
        return -1;
    }

    private static void initVertexNeighbour(VertexForMatrix currentVertex,int currentX,int currentY,List<List<VertexForMatrix>>map) {
        for(int i=currentX-1;i<currentX+2;i++){
            for(int j=currentY-1;j<currentY+2;j++){
                if(i!=currentX || j!=currentY) {
                    if (i >= 0 && i < map.size() && j >= 0 && j < map.get(i).size()) {
                        currentVertex.getIndexesOfNeighbourVertex().add(new PairCoordinate(i, j));
                    }
                }
            }
        }
    }
}
