package org.example.Math.array;

import java.util.HashMap;

public class ArraySumOfTwoNumbers {

    public static void main(String []arg){
        int array[]=new int[]{1,1,3,5,5};
        int target=80;
        int result[]=twoSum(array,target);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            Integer currentNumber = map.get(target - nums[i]);
            if (currentNumber != null && currentNumber >= 0 && currentNumber!=i) {
                int result[]=new int[]{i,currentNumber};
                return result;
            }
        }
        return null;
    }
}
