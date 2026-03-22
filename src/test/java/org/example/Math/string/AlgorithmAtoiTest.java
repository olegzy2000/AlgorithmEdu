package org.example.Math.string;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlgorithmAtoiTest {

    public AlgorithmAtoi algorithmAtoi;
    @BeforeEach
    public void init(){
        algorithmAtoi = new AlgorithmAtoi();
    }

    @ParameterizedTest
    @CsvSource({
            "1 , 1",
            "-24 , -24",
            "+24 , 24",
            "acr , 0",
            "123y645 , 123",
            "-042 , -42",
            " 1337c0d3 , 1337",
            "-91283472332 , -2147483648",
            "20000000000000000000 , 2147483647"

    })
    public void atoi(String input , int expected) {
        int actual = algorithmAtoi.atoi(input);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test1() {
        String input = "-91283472332";
        int actual = algorithmAtoi.atoi(input);
        Assert.assertEquals(-2147483648,actual );
    }
}