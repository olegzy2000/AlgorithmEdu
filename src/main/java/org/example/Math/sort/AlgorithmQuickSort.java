package org.example.Math.sort;

import java.util.LinkedList;

public class AlgorithmQuickSort {
    public static int[] quickSort(int []array){
        if(array==null || array.length==0 || array.length==1) {
            return array;
        }
        //quickSort(array,0,array.length-1);
        quickSortUsingStack(array);
        return array;
    }

    private static void quickSort(int[] array, int low, int high) {
        int strongElement=array[((high+low)/2)];
        int i=low;
        int j=high;
        if(i<j) {
            while(i<=j) {
                while (array[i] < strongElement)
                    i++;
                while (array[j] > strongElement)
                    j--;
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            if(low<j)
                quickSort(array,low,j);
            if(i<high)
                quickSort(array,i,high);
        }
    }

    public static int[] quickSortUsingStack(int[] array){
        if(array==null || array.length==0 || array.length==1) {
            return array;
        }
        LinkedList<Integer>stack=new LinkedList<>();
        stack.add(array.length-1);
        stack.add(0);
        while (!stack.isEmpty()){
            int high = stack.removeFirst();
            int low = stack.removeFirst();

            if (low >= high) {
                continue;
            }

            int i=low;
            int j=high;
            int pivot = array[(i + j)/2];
            while (i<=j){
                while (array[i]<pivot)i++;
                while (array[j]>pivot)j--;

                if(i<=j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            if(low<j) {
                stack.addFirst(low);
                stack.addFirst(j);
            }
            if(high>i) {
                stack.addFirst(i);
                stack.addFirst(high);
            }
        }
        return array;
    }

}
