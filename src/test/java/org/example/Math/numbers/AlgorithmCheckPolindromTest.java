package org.example.Math.numbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class AlgorithmCheckPolindromTest {

    private AlgorithmCheckPolindrom algorithmCheckPolindrom;
    @BeforeEach
    public void setUp() throws Exception {
        algorithmCheckPolindrom = new AlgorithmCheckPolindrom();
    }

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "11 , true",
        "121 , true",
        "1234 , false",
        "1221 , true",
         "-121 , false"
    })
    public void testBasesCases(int number, boolean expected){
        boolean actual = algorithmCheckPolindrom.checkPolindrom(number);
        Assert.assertEquals(expected,actual);
    }

}