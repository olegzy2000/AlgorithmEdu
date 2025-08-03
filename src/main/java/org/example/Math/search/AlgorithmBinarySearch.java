package org.example.Math.search;

public class AlgorithmBinarySearch {
    public Integer binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0,arr.length - 1);
    }
    private Integer binarySearch(int[] arr, int target, int low, int high) {
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] > target){
            return binarySearch(arr, target, low, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, high);
    }
}
