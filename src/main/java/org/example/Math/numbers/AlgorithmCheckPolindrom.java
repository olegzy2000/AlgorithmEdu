package org.example.Math.numbers;


public class AlgorithmCheckPolindrom {
    public boolean checkPolindrom(int number){

        if(number<0){
            return false;
        }
        if(number<10){
            return true;
        }
        int reverse = 0;
        int oldNumber = number;

        while (oldNumber>0){
            reverse = reverse*10 + oldNumber%10;
            oldNumber /= 10;
        }

        return reverse==number;
    }
}
