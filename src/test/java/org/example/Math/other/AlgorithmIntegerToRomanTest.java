package org.example.Math.other;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class AlgorithmIntegerToRomanTest {
    private AlgorithmIntegerToRoman algorithmIntegerToRoman;
    @BeforeEach
    public void setUp() throws Exception {
        algorithmIntegerToRoman = new AlgorithmIntegerToRoman();
    }

    @ParameterizedTest
    @CsvSource({
             "I , 1"
            ,"IV , 4"
            ,"VI , 6"
            ,"MCXIV , 1114"
            ,"MMMDCCXLIX , 3749"
            ,"LVIII , 58"
            ,"MCMXCIV , 1994"})
    public void intToRoman(String expected, int input) {
        String actual = algorithmIntegerToRoman.intToRoman(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({
            "I , 1"
            ,"IV , 4"
            ,"VI , 6"
            ,"MCXIV , 1114"
            ,"MMMDCCXLIX , 3749"
            ,"LVIII , 58"
            ,"MCMXCIV , 1994"})
    public void romanToInt(String input, int expected) {
        int actual = algorithmIntegerToRoman.romanToInt(input);
        assertEquals(expected,actual);
    }

    @Test
    public void test() {
        String number = "VI";
        int actual = algorithmIntegerToRoman.romanToInt(number);
        assertEquals(6,actual);
    }


}