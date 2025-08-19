package org.example.Math.chess;

import org.example.Math.chess.model.ConstLinerFunction;
import org.example.Math.chess.model.LinerFunction;
import org.example.Math.chess.model.ResultCoordinates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EightQueens {
    public static HashSet<List<ResultCoordinates>> getListPositionOfEightQueens() {
        HashSet<List<ResultCoordinates>> arrayResultCoordinatesList = new HashSet<>();
        HashSet<LinerFunction> blockLinerFunction = new HashSet<>();
        HashSet<ConstLinerFunction> blockConstLinerFunction = new HashSet<>();
        checkCoordinates(arrayResultCoordinatesList, new ArrayList<>(), blockConstLinerFunction, blockLinerFunction, 0);
        return arrayResultCoordinatesList;
    }

    private static void checkCoordinates(HashSet<List<ResultCoordinates>> resultCoordinatesList,
                                         List<ResultCoordinates> currentResultCoordinates,
                                         HashSet<ConstLinerFunction> blockConstLinerFunction,
                                         HashSet<LinerFunction> blockLinerFunction, int row) {
        if (currentResultCoordinates.size() == 8) {
            resultCoordinatesList.add(new ArrayList<>(currentResultCoordinates));
            return;
        }
        for(int col=0;col<8;col++) {
            ConstLinerFunction constLinerFunctionX = new ConstLinerFunction();
            constLinerFunctionX.setX(row);
            ConstLinerFunction constLinerFunctionY = new ConstLinerFunction();
            constLinerFunctionY.setY(col);
            LinerFunction upLinerFunction = createLinerFunctionByTwoPoints(row, col, row + 1, col + 1);
            LinerFunction downLinerFunction = createLinerFunctionByTwoPoints(row, col, row + 1, col - 1);
            if (!blockLinerFunction.contains(upLinerFunction)
                    && !blockLinerFunction.contains(downLinerFunction)
                    && !blockConstLinerFunction.contains(constLinerFunctionX)
                    && !blockConstLinerFunction.contains(constLinerFunctionY)
            ) {
                blockLinerFunction.add(upLinerFunction);
                blockLinerFunction.add(downLinerFunction);
                blockConstLinerFunction.add(constLinerFunctionX);
                blockConstLinerFunction.add(constLinerFunctionY);
                ResultCoordinates resultCoordinates = new ResultCoordinates();
                resultCoordinates.setxCoordinate(row);
                resultCoordinates.setyCoordinate(col);
                currentResultCoordinates.add(resultCoordinates);
                checkCoordinates(resultCoordinatesList, currentResultCoordinates, blockConstLinerFunction, blockLinerFunction, row+1);

                currentResultCoordinates.remove(currentResultCoordinates.size() - 1);
                blockLinerFunction.remove(upLinerFunction);
                blockLinerFunction.remove(downLinerFunction);
                blockConstLinerFunction.remove(constLinerFunctionX);
                blockConstLinerFunction.remove(constLinerFunctionY);
            }
        }

    }

    private static LinerFunction createLinerFunctionByTwoPoints(int i, int j, int i1, int j1) {
        //i=k*j+b
        //i1=k*j1+b
        //i-i1=k*(j-j1);
        LinerFunction linerFunction = new LinerFunction();
        float k = (float) (i - i1) / (j - j1);
        linerFunction.setK(k);
        float b = i - (k * j);
        linerFunction.setB(b);
        return linerFunction;
    }
}
