package org.example.Math;

import java.util.HashSet;
import java.util.Set;

public class AlgorithmCheckAnnogram {
    public static boolean checkAnnogram(String firstString,String secondString){
        if(firstString==null || secondString==null)
            return false;
        if(firstString.isEmpty() && secondString.isEmpty())
            return true;
        char []firstCharArray=firstString.toCharArray();
        char []secondCharArray=secondString.toCharArray();
        HashSet<Character> firstSet=new HashSet<>();
        for(int i=0;i<firstCharArray.length;i++){
           firstSet.add(firstCharArray[i]);
        }

        HashSet<Character> secondSet=new HashSet<>();
        for(int i=0;i<secondCharArray.length;i++){
            secondSet.add(secondCharArray[i]);
        }
        return firstSet.equals(secondSet);
    }
}
