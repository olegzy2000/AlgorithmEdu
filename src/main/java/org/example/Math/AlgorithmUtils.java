package org.example.Math;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmUtils {

    public static void generateSequence(int amount){
        List<String>stringList=new ArrayList<>();
        generateSequenceString(stringList,"",amount,0,0);
        System.out.println(stringList);
    }

    private static void generateSequenceString(List<String> stringList, String current, int amount, int closeCount, int openCount) {
        if(current.length()==amount*2){
            stringList.add(current);
            return;
        }
        if(openCount<amount){
            generateSequenceString(stringList,current+"(",amount,closeCount,openCount+1);
        }
        if(closeCount<openCount){
            generateSequenceString(stringList,current+")",amount,closeCount+1,openCount);
        }
    }
}
