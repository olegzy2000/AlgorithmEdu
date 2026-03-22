package org.example.Math.string;

/*
На вход подается массив строк отсортированный в
лексикографическом порядке а так же префикс
нужно определить количество строк который начинаются
с этого префикса
*/

public class AlgorithmPrefixTask {
    public static int startBinary(String[] array, String prefix){
        int left=0;
        int right=array.length-1;
        int currentIndex=-1;
        int leftIndex=-1;
        //search left index
        while(left<=right){
            currentIndex = (left+right)/2;
            if(currentIndex >=0 && currentIndex < array.length){
                String currentString = array[currentIndex];
                if (currentString!=null && currentString.length() >= prefix.length()){
                    String currentStringPrefix = currentString.substring(0,prefix.length());
                    int compareResult = currentStringPrefix.compareTo(prefix);
                      if(compareResult < 0){
                          left = currentIndex + 1;
                      }
                      else if(compareResult==0){
                          leftIndex = currentIndex;
                          right = currentIndex - 1;
                      }
                      else if(compareResult > 0){
                          right = currentIndex - 1;
                      }
                }
                else{
                    left = currentIndex + 1;
                }

            }
        }

        int rightIndex=-1;
        left=0;
        right=array.length-1;
        //search left index
        while(left<=right){
            currentIndex = (left+right)/2;
            if(currentIndex >=0 && currentIndex < array.length){
                String currentString = array[currentIndex];
                if (currentString!=null && currentString.length() >= prefix.length()){
                    String currentStringPrefix = currentString.substring(0,prefix.length());
                    int compareResult = currentStringPrefix.compareTo(prefix);
                    if(compareResult < 0){
                        left = currentIndex + 1;
                    }
                    else if(compareResult==0){
                        rightIndex = currentIndex;
                        left = currentIndex + 1;
                    }
                    else if(compareResult > 0){
                        right = currentIndex - 1;
                    }
                }
                else{
                    left = currentIndex + 1;
                }
            }
        }

        if(rightIndex==-1 && leftIndex==-1){
            return 0;
        }
        if(rightIndex==-1 || leftIndex==-1){
            return 1;
        }
        return rightIndex - leftIndex + 1;

    }
}
