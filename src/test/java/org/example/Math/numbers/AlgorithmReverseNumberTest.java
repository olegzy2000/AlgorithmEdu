package org.example.Math.numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlgorithmReverseNumberTest {
    private AlgorithmReverseNumber algorithmReverseNumber;
    @BeforeEach
    public void setUp() throws Exception {
        algorithmReverseNumber = new AlgorithmReverseNumber();
    }

    @CsvSource({
            "123 , 321"
            ,"-123 , -321"
            ,"1 , 1"
            ,"-1 , -1"
            ,"9646324351 , 0"
    })
    @ParameterizedTest
    public void reverse( int input, int result) {
        Assertions.assertEquals(result, algorithmReverseNumber.reverse(input));
    }
}