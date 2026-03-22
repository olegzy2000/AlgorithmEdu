package org.example.Math.string;

public class AlgorithmAtoi {
    public int atoi(String number){

        number=number.trim();
        if(number==null || number.isEmpty()){
            return 0;
        }
        char []arraySymbols = number.toCharArray();
        int symbol=1;
        int start = 0;
        if(arraySymbols[0]=='-'){
            start = 1;
            symbol=-1;
        }
        if(arraySymbols[0]=='+'){
            start=1;
        }
        long resultNumber=0;
        int currentNumber;
        while (start<arraySymbols.length && arraySymbols[start]=='0'){
            start++;
        }
        for(int i = start;i<arraySymbols.length;i++ ){
            currentNumber = Character.getNumericValue(arraySymbols[i]);
            if(currentNumber>=0 && currentNumber<=9)
            {
              resultNumber+=currentNumber;
              resultNumber*=10;

                if((symbol*resultNumber)/10<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if((symbol*resultNumber/10)>Integer.MAX_VALUE ){
                    return Integer.MAX_VALUE;
                }

            }
            else {
                i = arraySymbols.length;
            }
        }
        resultNumber*=symbol;
        resultNumber/=10;
        if(resultNumber<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(resultNumber>Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }

        return (int)resultNumber;
    }
}
