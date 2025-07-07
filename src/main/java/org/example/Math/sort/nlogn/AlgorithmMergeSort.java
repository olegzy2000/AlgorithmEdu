package org.example.Math.sort.nlogn;

public class AlgorithmMergeSort {
    public static int[] mergeSort(int []array){
        if(array == null || array.length == 0 || array.length == 1)
            return array;

        return array;
    }
    public static int[] merge(int []array,int firstStart,int firstEnd,int secondStart,int secondEnd){
        int currentPosition=firstStart;
        int numberFromFirstPart=array[firstStart];
        int numberFromSecondPart=array[secondStart];
        int arrayResult[]=new int[array.length];
        while(firstStart<=firstEnd || secondStart<=secondEnd){
            if(secondStart<=secondEnd && numberFromFirstPart>numberFromSecondPart){
                arrayResult[currentPosition]=numberFromSecondPart;
                secondStart++;
                if(secondStart<=secondEnd) {
                    numberFromSecondPart = array[secondStart];
                }
                else{
                    numberFromSecondPart=Integer.MAX_VALUE;
                }
            }
            else if(firstStart<=firstEnd && numberFromFirstPart<numberFromSecondPart){
                arrayResult[currentPosition]=numberFromFirstPart;
                firstStart++;
                if(firstStart<=firstEnd) {
                    numberFromFirstPart = array[firstStart];
                }
                else{
                    numberFromFirstPart=Integer.MAX_VALUE;
                }
            }
            currentPosition++;
        }
        return arrayResult;

    }
}
