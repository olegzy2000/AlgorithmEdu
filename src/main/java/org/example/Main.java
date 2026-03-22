package org.example;
public class Main {
    public static void main(String[] args) {
        System.out.println(1/2);
       int []firstArray=new int[]{1,2,3,4,5};
        int []secondArray=new int[]{6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(findMedianSortedArrays(firstArray,secondArray));//0

/*
        firstArray=new int[]{1,3,4};
        secondArray=new int[]{5};

        System.out.println(findMedianSortedArrays(secondArray,firstArray));*/
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1==null || nums1.length==0){
            return simpleMedianOfArray(nums2);
        }
        else if(nums2==null || nums2.length==0){
            return simpleMedianOfArray(nums1);
        }

        if(nums2.length<nums1.length){
            int []current = nums1;
            nums1 = nums2;
            nums2 = current;
        }

       int left=0;
       int right=nums1.length;


       int firstMinRight=0;
       int firstMaxLeft=0;

       int secondMinRight=0;
       int secondMaxLeft=0;

       int amountLeft = 0;
        amountLeft = (nums1.length + nums2.length + 1) / 2;

        int commonAmount = nums1.length + nums2.length;
       while(left<=right){
           int mid1 = (left + right )/2;
           firstMinRight = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE  ;
           firstMaxLeft = mid1 - 1 >= 0 ? nums1[mid1-1] : Integer.MIN_VALUE ;
           int mid2 = amountLeft - mid1;
           secondMinRight = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE  ;
           secondMaxLeft = mid2 - 1 >= 0 ? nums2[mid2-1] : Integer.MIN_VALUE ;

           if(firstMinRight >= secondMaxLeft && secondMinRight >= firstMaxLeft){
               if(commonAmount%2==0){
                   double minRight = Math.min(firstMinRight,secondMinRight);
                   double maxLeft = Math.max(firstMaxLeft,secondMaxLeft);
                   return (minRight+maxLeft)/2;
               }
               else {
                   return Math.max(firstMaxLeft,secondMaxLeft);
               }
           }
           else {
               if(firstMinRight<secondMaxLeft) {
                   left = mid1 + 1;
               }
               else{
                   right = mid1 - 1;
               }
           }
        }
        if(commonAmount%2==0){
            double minRight = Math.min(firstMinRight,secondMinRight);
            double maxLeft = Math.max(firstMaxLeft,secondMaxLeft);
            return (minRight+maxLeft)/2;
        }
        else {
            return Math.max(firstMaxLeft,secondMaxLeft);
        }
    }

    private static double simpleMedianOfArray(int[] nums1) {
        if(nums1.length%2==0){
            return (double) (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
        }
        else{
            return nums1[nums1.length/2];
        }
    }
}



