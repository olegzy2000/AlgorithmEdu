package org.example.Math.graph;

import org.example.Math.model.City;
import org.example.Math.model.VertexForGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmBsfGraph {
    public static void bsfStartWithCites(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cities[i] = new City(i, x, y);
        }

        int k = scanner.nextInt();
        int startCityIndex = scanner.nextInt() - 1;
        int endCityIndex = scanner.nextInt() - 1;

        // Создаем граф
        List<VertexForGraph> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new VertexForGraph());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cities[i].distanceTo(cities[j]) <= k) {
                    graph.get(i).getIndexesOfNeighbourVertex().add(j);
                    graph.get(j).getIndexesOfNeighbourVertex().add(i);
                }
            }
        }
        int result=-1;
        if(startCityIndex==endCityIndex) {
            System.out.println(0);
        }
        else if(graph.get(startCityIndex).equals(graph.get(endCityIndex))){
            System.out.println(0);
        }
        else if(startCityIndex<0 || startCityIndex>graph.size()-1){
            System.out.println(-1);
        }
        else if(endCityIndex<0 || endCityIndex>graph.size()-1){
            System.out.println(-1);
        }
        else {
            result = bfs(graph, startCityIndex, endCityIndex);
            System.out.println(result);
        }

    }


    private static int bfs(List<VertexForGraph> graph, int start, int end) {
        LinkedList<VertexForGraph> linkedList=new LinkedList<>();
        graph.get(start).setVisited(true);
        graph.get(start).setDistanceToStart(0);
        linkedList.addFirst(graph.get(start));
        int distance=1;
        while (!linkedList.isEmpty()){
            VertexForGraph current=linkedList.removeFirst();
            for(int i=0;i<current.getIndexesOfNeighbourVertex().size();i++){
                int indexOfCurrentNeighbour=current.getIndexesOfNeighbourVertex().get(i);
                VertexForGraph currentVertex=graph.get(indexOfCurrentNeighbour);
                if(!currentVertex.isVisited()){
                    currentVertex.setVisited(true);
                    currentVertex.setDistanceToStart(distance);
                    linkedList.add(currentVertex);
                }
            }
            if(graph.get(end).isVisited()){
                return distance;
            }
            distance++;
        }
        return -1;
    }
}
