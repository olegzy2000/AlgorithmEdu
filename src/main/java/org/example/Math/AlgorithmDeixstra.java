package org.example.Math;

import org.example.Math.model.PairVertexAndEdgeSize;
import org.example.Math.model.Vertex;
import org.example.Math.model.VertexForGraph;
import org.example.Math.model.VertexForGraphWithEdgeSize;

import java.util.*;
import java.util.stream.Collectors;

public class AlgorithmDeixstra {
    public static int calculateMinWayToGraph(int[][] listEdge,int start ,int end){
        int way=0;
        int countOfVertex=-1;
        for(int i=0;i<listEdge.length;i++){
            for(int j=0;j<3;j++){
                if(listEdge[i][j]>countOfVertex){
                    countOfVertex=listEdge[i][j];
                }
            }
        }
        List<VertexForGraphWithEdgeSize>vertexList=new ArrayList<>();
        for (int i=0;i<countOfVertex;i++){
            vertexList.add(new VertexForGraphWithEdgeSize());
        }
        vertexList.get(start).setDistanceToStart(0);
        vertexList.get(start).setVisited(true);
        for (int i=0;i<listEdge.length;i++){
            int firstVertex=listEdge[i][0];
            int secondVertex=listEdge[i][1];
            int edgeSize=listEdge[i][2];
            VertexForGraphWithEdgeSize firstVertexObject=vertexList.get(firstVertex);
            VertexForGraphWithEdgeSize secondVertexObject=vertexList.get(secondVertex);

            PairVertexAndEdgeSize firstNeighbour=new PairVertexAndEdgeSize();
            firstNeighbour.setEdgeSize(edgeSize);
            firstNeighbour.setNumberVertex(secondVertex);
            firstVertexObject.getListPairNumberOfVertexAndSizeOfEdge().add(firstNeighbour);

            PairVertexAndEdgeSize secondNeighbour=new PairVertexAndEdgeSize();
            secondNeighbour.setEdgeSize(edgeSize);
            secondNeighbour.setNumberVertex(firstVertex);
            secondVertexObject.getListPairNumberOfVertexAndSizeOfEdge().add(secondNeighbour);
        }
        LinkedList<VertexForGraphWithEdgeSize>linkedList=new LinkedList<>();
        linkedList.add(vertexList.get(start));
        while (!linkedList.isEmpty()){
            VertexForGraphWithEdgeSize vertex=linkedList.removeFirst();
            for(PairVertexAndEdgeSize pairVertexAndEdgeSize:vertex.getListPairNumberOfVertexAndSizeOfEdge()){
                VertexForGraphWithEdgeSize currentVertex=vertexList.get(pairVertexAndEdgeSize.getNumberVertex());
                if(!currentVertex.isVisited()) {
                    int currentDistanceInVertex = currentVertex.getDistanceToStart();
                    if (currentDistanceInVertex > vertex.getDistanceToStart() + pairVertexAndEdgeSize.getEdgeSize()) {
                        currentVertex.setDistanceToStart(vertex.getDistanceToStart() + pairVertexAndEdgeSize.getEdgeSize());
                    }
                }
            }
            List<Integer> numbersOfVertex=vertex.getListPairNumberOfVertexAndSizeOfEdge().stream().map(PairVertexAndEdgeSize::getNumberVertex).collect(Collectors.toList());
            sortedNumberOfVertex(numbersOfVertex,vertexList);
            for(Integer index:numbersOfVertex){
                if(!vertexList.get(index).isVisited())
                linkedList.add(vertexList.get(index));
            }
            vertex.setVisited(true);
        }
        return vertexList.get(end).getDistanceToStart();
    }

    private static void sortedNumberOfVertex(List<Integer> numbersOfVertex, List<VertexForGraphWithEdgeSize> vertexList) {
        for(int i=0;i<numbersOfVertex.size();i++){
            for(int j=i+1;j<numbersOfVertex.size();j++){
                if(vertexList.get(numbersOfVertex.get(i)).getDistanceToStart()>vertexList.get(numbersOfVertex.get(j)).getDistanceToStart()){
                    try {
                        int swap = numbersOfVertex.get(i);
                        numbersOfVertex.set(i, numbersOfVertex.get(j));//
                        numbersOfVertex.set(j, swap);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
