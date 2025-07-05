package org.example.Math.sort;
public class AlgorithmQuickSort {
    public static int[] quickSort(int []array){
        if(array==null || array.length==0 || array.length==1) {
            return array;
        }
        quickSort(array,0,array.length-1);
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
}
