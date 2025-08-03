package org.example.Math.chess;

import org.example.Math.chess.model.ConstLinerFunction;
import org.example.Math.chess.model.LinerFunction;
import org.example.Math.chess.model.ResultCoordinates;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    public static int getCountOfPossiblePosition(int sizeX, int sizeY){
        List<ResultCoordinates> resultCoordinatesList=new ArrayList<ResultCoordinates>();
        List<LinerFunction>blockLinerFunction=new ArrayList<>();
        List<ConstLinerFunction>blockConstLinerFunction=new ArrayList<>();
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                ConstLinerFunction constLinerFunctionX=new ConstLinerFunction();
                constLinerFunctionX.setX(i);
                ConstLinerFunction constLinerFunctionY=new ConstLinerFunction();
                constLinerFunctionY.setY(j);
                LinerFunction upLinerFunction=createLinerFunctionByTwoPoints(i,j,i+1,j+1);
                LinerFunction downLinerFunction=createLinerFunctionByTwoPoints(i,j,i+1,j-1);
                if(!blockLinerFunction.contains(upLinerFunction)
                        && !blockLinerFunction.contains(downLinerFunction)
                &&  !blockConstLinerFunction.contains(constLinerFunctionX)
                &&  !blockConstLinerFunction.contains(constLinerFunctionY)
                ){
                    blockLinerFunction.add(upLinerFunction);
                    blockLinerFunction.add(downLinerFunction);
                    blockConstLinerFunction.add(constLinerFunctionX);
                    blockConstLinerFunction.add(constLinerFunctionY);
                    ResultCoordinates resultCoordinates=new ResultCoordinates();
                    resultCoordinates.setxCoordinate(i);
                    resultCoordinates.setyCoordinate(j);
                    resultCoordinatesList.add(resultCoordinates);
                }
            }
        }

        return resultCoordinatesList.size();
    }

    private static LinerFunction createLinerFunctionByTwoPoints(int i, int j, int i1, int j1) {
        //i=k*j+b
        //i1=k*j1+b
        //i-i1=k*(j-j1);
        LinerFunction linerFunction=new LinerFunction();
        float k = (i-i1)/(j-j1);
        linerFunction.setK(k);
        float b = i-(k*j);
        linerFunction.setB(b);
        return linerFunction;
    }
}
