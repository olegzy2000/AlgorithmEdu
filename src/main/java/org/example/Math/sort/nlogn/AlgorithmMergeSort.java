package org.example.Math.sort.nlogn;

import java.util.Arrays;

public class AlgorithmMergeSort {
    public static int[] mergeSort(int []array){
        if(array == null || array.length == 0 || array.length == 1)
            return array;
        int arraySize = array.length;
        separateArray(array,0,arraySize-1);
        return array;
    }

    public static void separateArray(int[] array, int start, int end) {
        if(start == end)
            return;
        int mid=(start+end)/2;
        if(start<end) {
            separateArray(array, start, mid);
            separateArray(array, mid+1,end);
            System.out.println("------------------------------------------");
            for(int i=start; i<=end; i++){
                System.out.print(array[i]+" ");
            }
            System.out.println("start:"+start+" mid:"+mid+" end:"+end);
            System.out.println("------------------------------------------");
            merge(array,start,mid,mid+1,end);
        }
        //
    }

    public static void merge(int []array,int firstStart,int firstEnd,int secondStart,int secondEnd){
        if(array.length==0
                || array.length==1
                || firstStart>firstEnd
                || secondStart>secondEnd
        || firstStart>=secondStart
                || firstEnd>=secondStart)
            return ;
        int currentResultPosition=0;
        int currentFirstPosition=firstStart;
        int currentSecondPosition=secondStart;
        int arrayResult[]=new int[secondEnd-firstStart+1];
        while(currentFirstPosition<=firstEnd && currentSecondPosition<=secondEnd
                && currentSecondPosition<array.length
                && currentFirstPosition<array.length){
            if(array[currentFirstPosition]<array[currentSecondPosition]){
                arrayResult[currentResultPosition]=array[currentFirstPosition];
                currentFirstPosition++;
            }
            else{
                arrayResult[currentResultPosition]=array[currentSecondPosition];
                currentSecondPosition++;
            }
            currentResultPosition++;
        }

        while(currentFirstPosition<array.length && currentFirstPosition<=firstEnd){
            arrayResult[currentResultPosition]=array[currentFirstPosition];
            currentResultPosition++;
            currentFirstPosition++;
        }
        while( currentSecondPosition<array.length && currentSecondPosition<=secondEnd){
            arrayResult[currentResultPosition]=array[currentSecondPosition];
            currentResultPosition++;
            currentSecondPosition++;
        }

        for (int j=0,i = firstStart; i <= secondEnd; i++,j++) {
           array[i] = arrayResult[j];
        }
    }
}
