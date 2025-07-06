package org.example.Math.sort.nn;

public class AlgorithmInsertSort {
    public static int[] InsertSort(int[] array){
        if(array==null || array.length==0 || array.length==1){
            return array;
        }
        for(int i=0;i<array.length;i++){
            int element = array[i];
            for(int j=i-1;j>=0 && array[j]>element;j--){
                array[j+1]=array[j];
                array[j]=element;
            }
        }
        return array;
    }
}
