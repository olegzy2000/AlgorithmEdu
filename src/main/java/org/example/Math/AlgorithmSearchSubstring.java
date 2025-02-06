package org.example.Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AlgorithmSearchSubstring {

    public static int findMaxUniqueSubstringLength(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int right=0;
        int left=0;
        int max=0;
        LinkedHashSet<Character> set=new LinkedHashSet<Character>();
        LinkedHashSet<Character>result=new LinkedHashSet<Character>();
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(s.charAt(right));
                right++;
                max=Math.max(max,set.size());
                if(set.size()>result.size()){
                    result.clear();
                    result.addAll(set);
                }
            }
        }
        System.out.println(result);
        return max;
    }
}
