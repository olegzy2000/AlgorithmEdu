package org.example.Math.string;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmGenerateBracketSequence {
    public static List<String> generateSequenceUseRecourse(int amount){
        List<String>result=new ArrayList<>();
        generateSequenceUseRecourse(result,"",amount,0,0);
        return result;
    }

    private static void generateSequenceUseRecourse(List<String> result, String current, int amount, int openAmount, int closeAmount) {
        if(current.length()==amount*2){
            result.add(current);
            return;
        }
        if(openAmount<amount){
            generateSequenceUseRecourse(result,current+'(',amount,openAmount+1,closeAmount);
        }
        if(closeAmount<openAmount){
            generateSequenceUseRecourse(result,current+')',amount,openAmount,closeAmount+1);
        }
    }

    public static List<String> generateSequenceUseIteration(int amount){
        List<String>result=new ArrayList<>();
        if(amount<0){
            return result;
        }
        List<String>stack=new ArrayList<>();
        stack.add("");
        int openAmount=0;
        int closeAmount=0;
        while (!stack.isEmpty()){
            String current=stack.remove(stack.size()-1);
            openAmount=calculateAmountCharInString(current,'(');
            closeAmount=calculateAmountCharInString(current,')');
            if(openAmount<amount){
                stack.add(current+'(');
            }
            if(closeAmount<openAmount){
                stack.add(current+')');
            }
            if(current.length()==2*amount){
                result.add(current);
            }
        }
        return result;
    }

    private static int calculateAmountCharInString(String current, char character) {
        int result=0;
        for(int i=0;i<current.length();i++){
            if(character==current.charAt(i)){
                result++;
            }
        }
        return result;
    }


}
