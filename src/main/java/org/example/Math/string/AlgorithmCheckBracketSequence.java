package org.example.Math.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmCheckBracketSequence {
    public static boolean checkSequenceUseBalance(String sequence){
        if(sequence==null || sequence.isEmpty()){
            return true;
        }
        int balance=0;
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i)=='(')
                balance++;
            else if(sequence.charAt(i)==')')
                balance--;
            else{
                return false;
            }
        }
        if(balance==0)
            return true;
        return false;
    }
    public static boolean checkSequenceUseStack(String sequence){
        if(sequence==null || sequence.isEmpty()){
            return true;
        }
        LinkedList<Character>stack=new LinkedList<>();
        int balance=0;
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i)=='(')
                stack.addFirst(sequence.charAt(i));
            else if(sequence.charAt(i)==')')
                stack.removeFirst();
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }



}
