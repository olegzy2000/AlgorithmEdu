package org.example.Math.search;

public class AlgorithmSearchingInterpolation {
    public int searchingInterpolation(int[] arr, int target) {
        return searchingInterpolation(arr, target, 0,arr.length - 1);
    }

    private int searchingInterpolation(int[] arr, int target, int low, int high) {
        if (low >= high)
            return -1;
        int minElement=arr[low];
        int maxElement=arr[high];
        int currentMoveElement=maxElement-minElement;
        int targetMoveElement=target-minElement;
        float percentIndex=targetMoveElement/currentMoveElement;
        int indexForCheck=(int)((high-low)*percentIndex)+low;
        if(arr[indexForCheck]==target){
            return indexForCheck;
        }
        else if(target<arr[indexForCheck]){
            return searchingInterpolation(arr, target, low, indexForCheck-1);
        }
        else if(target>arr[indexForCheck]){
            return searchingInterpolation(arr, target, indexForCheck+1, high);
        }
        return -1;
    }
}
