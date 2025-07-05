package org.example.Math;

import org.example.Math.string.AlgorithmSearchSubstring;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmSearchSubstringTest {

    @Test
    public void findMaxUniqueSubstring() {
       /* String result;
        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("");
        assertEquals("",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("aaaa");
        assertEquals("a",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("aaab");
        assertEquals("ab",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("abcd");
        assertEquals("abcd",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("aabcdd");
        assertEquals("abcd",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring("aabbccdd");
        assertEquals("ab",result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstring(null);
        assertNull(result);*/
    }

    @Test
    public void findMaxUniqueSubstringLength() {
        int result;
        result= AlgorithmSearchSubstring.findMaxUniqueSubstringLength("");
        assertEquals(0,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength("aaaa");
        assertEquals(1,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength("aaab");
        assertEquals(2,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength("abcd");
        assertEquals(4,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength("aabcdd");
        assertEquals(4,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength("aabbccdd");
        assertEquals(2,result);

        result=AlgorithmSearchSubstring.findMaxUniqueSubstringLength(null);
        assertEquals(0,result);
    }
}