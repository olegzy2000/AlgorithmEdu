package org.example.Math.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AlgorithmMaxWaterTest {
    private AlgorithmMaxWater algorithmMaxWater;

    @BeforeEach
    public void init(){
        algorithmMaxWater = new AlgorithmMaxWater();
    }
    @ParameterizedTest
    @CsvSource({
            "'1,8,6,2,5,4,8,3,7', 49",
            "'1, 1', 1"
    })
    public void startTest(String inputStr, int expected) {

        int[] input = Arrays.stream(inputStr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        int actual = algorithmMaxWater.start(input);
        assertEquals(expected, actual);
    }
}