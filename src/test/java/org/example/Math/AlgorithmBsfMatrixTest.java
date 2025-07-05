package org.example.Math;

import org.example.Math.graph.AlgorithmBsfMatrix;
import org.example.Math.model.PairCoordinate;
import org.junit.Assert;
import org.junit.Test;

public class AlgorithmBsfMatrixTest {

    @Test
    public void bsfStartWithMap() {
          int[][] map=new int[][]{
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };
        PairCoordinate startCoordinate=new PairCoordinate(0,0);
        PairCoordinate endCoordinate=new PairCoordinate(4,4);
        int result= AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(4,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(0,4);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(4,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(4,0);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(4,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(0,0);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(0,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(0,1);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(1,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(1,0);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(1,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(1,1);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(1,result);

        startCoordinate=new PairCoordinate(0,0);
        endCoordinate=new PairCoordinate(2,2);
        result=AlgorithmBsfMatrix.bsfStartWithMap(map,startCoordinate,endCoordinate);
        Assert.assertEquals(2,result);

    }
}