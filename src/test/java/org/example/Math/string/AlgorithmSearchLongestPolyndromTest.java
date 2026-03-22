package org.example.Math.string;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlgorithmSearchLongestPolyndromTest {

    @CsvSource({
            "appa, appa",
            "apa, apa",
            "apal , apa",
            "a , a"
    })
    @ParameterizedTest
    public void searchLongestPolyndromSimple(String input,String expected) {
        String result = AlgorithmSearchLongestPolyndrom.searchLongestPolyndrom(input);
        Assert.assertEquals(result,expected);
    }

    @CsvSource({
            "appa, appa",
            "apa, apa",
            "apal , apa",
            "a , a",
            "aaa , aaa",
            "babad , bab",
            "cbbd , bb",
            "abbcccba ,bcccb ",
            "aaabaaaa , aaabaaa"
    })
    @ParameterizedTest
    public void searchLongestPolyndromManagerSimple(String input,String expected) {
        String result = AlgorithmSearchLongestPolyndrom.searchLongestPolyndromManaker(input);
        Assert.assertEquals(result,expected);
    }
    @Test
    public void test() {
        String result = AlgorithmSearchLongestPolyndrom.searchLongestPolyndromManaker("aaabaaaa");
        Assert.assertEquals(result,"aaabaaa");
    }
}