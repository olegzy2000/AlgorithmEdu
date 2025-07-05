package org.example.Math;

import org.example.Math.graph.AlgorithmDeixstra;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmDeixstraTest {

    @Test
    public void calculateMinWayToGraph() {
        int [][]array=new int[][]{
                {0,1,1},
                {1,2,5},
                {1,3,3},
                {2,3,2},
                {3,4,1},
                {2,4,4}};
        int start=0;
        int end=4;
        assertEquals(5, AlgorithmDeixstra.calculateMinWayToGraph(array,start,end));

        start=0;
        end=1;
        assertEquals(1, AlgorithmDeixstra.calculateMinWayToGraph(array,start,end));

        start=0;
        end=3;
        assertEquals(4, AlgorithmDeixstra.calculateMinWayToGraph(array,start,end));

        start=0;
        end=2;
        assertEquals(6, AlgorithmDeixstra.calculateMinWayToGraph(array,start,end));

        start=2;
        end=4;
        assertEquals(3, AlgorithmDeixstra.calculateMinWayToGraph(array,start,end));

    }
}