package org.example.Math.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class CombinationWithoutRepetition {
    public static List<List<Character>> start(char[]array,int sequenceSize){
        List<List<Character>>list=new ArrayList<>();
        resolve(list,new ArrayList<>(array.length),array,0,sequenceSize);
        return list;
    }

    private static void resolve(List<List<Character>> result, List<Character> current, char[] array, int index,int sequenceSize) {
        if(current.size()==sequenceSize){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<array.length;i++) {
            current.add(array[i]);
            resolve(result, current, array, i+1,sequenceSize);
            current.remove(current.size() - 1);
        }
    }
}
