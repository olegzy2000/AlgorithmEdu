package org.example.Math.string;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class AlgorithmZigZagStringTest {

    private AlgorithmZigZagString algorithmZigZagString;
    @BeforeEach
    public void setUp() throws Exception {
        algorithmZigZagString = new AlgorithmZigZagString();
    }

    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING , 3 , PAHNAPLSIIGYIR",
            "PAYPALISHIRING, 4 , PINALSIGYAHRPI",
            "A ,1 ,A",
            "AB,1,AB"
    })
    public void basicTest(String input, int rows, String expected){
        String actual = algorithmZigZagString.convert(input,rows);
        Assertions.assertEquals(expected,actual);
    }
}