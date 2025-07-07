package org.example.Math.sort.nlogn;
import org.junit.Test;

public class AlgorithmMergeSortTest {

    @Test
    public void merge() {
        int[] array=new int[]{4,5,6,1,2,3};
        array=AlgorithmMergeSort.merge(array,0,2,3,5);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}