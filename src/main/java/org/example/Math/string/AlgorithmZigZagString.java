package org.example.Math.string;

public class AlgorithmZigZagString {
    public String convert(String input, int numRows) {

        if(numRows==1)
            return input;
        StringBuilder[] resultArray = new StringBuilder[numRows];
        for(int i=0;i<resultArray.length;i++){
            resultArray[i] = new StringBuilder();
        }
        char[]inputCharArray = input.toCharArray();


        int firstOffset=0;
        int currentIndex=0;
        while (currentIndex<inputCharArray.length) {
            //handle col
            for (int i = firstOffset; i < numRows && currentIndex<inputCharArray.length; i++) {
                resultArray[i].append(inputCharArray[currentIndex]);
                currentIndex++;
            }
            firstOffset=1;
            //handle row
            for(int i = numRows-2 ; i>=0 && currentIndex<inputCharArray.length; i--){
                resultArray[i].append(inputCharArray[currentIndex]);
                currentIndex++;
            }

        }

        StringBuilder result= new StringBuilder();
        for(StringBuilder object:resultArray){
            System.out.println(object.toString());
            result.append(object);
        }

        return result.toString();
    }
}
