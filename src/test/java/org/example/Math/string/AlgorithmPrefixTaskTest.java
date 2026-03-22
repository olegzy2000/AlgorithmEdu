package org.example.Math.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmPrefixTaskTest {

    @Test
    public void basicTest() {
        String[] array = new String[]{"123", "Apple", "com", "combat", "computer", "data", "zebra", "zero", "zone", "zoo"};
        String prefix = "com";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(3, result);
    }

    @Test
    public void oneWordTest() {
        String[] array = new String[]{"123", "Apple", "com", "combat", "computer", "data", "zebra", "zero", "zone", "zoo"};
        String prefix = "Ap";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result);
    }

    @Test
    public void noMatchesTest() {
        String[] array = new String[]{"123", "Apple", "com", "combat", "computer", "data", "zebra", "zero", "zone", "zoo"};
        String prefix = "xyz";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(0, result);
    }

    @Test
    public void emptyArrayTest() {
        String[] array = new String[]{};
        String prefix = "com";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(0, result);
    }

    @Test
    public void singleElementArrayWithMatchTest() {
        String[] array = new String[]{"hello"};
        String prefix = "he";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result);
    }

    @Test
    public void singleElementArrayNoMatchTest() {
        String[] array = new String[]{"hello"};
        String prefix = "world";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(0, result);
    }

    @Test
    public void allWordsHavePrefixTest() {
        String[] array = new String[]{"abc", "abcd", "abcde", "abcdef"};
        String prefix = "ab";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(4, result);
    }

    @Test
    public void caseSensitiveTest() {
        String[] array = new String[]{"APPLE", "Apple", "apple", "banana"};;
        String prefix = "app";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result); // Только "apple" в нижнем регистре
    }

    @Test
    public void prefixAtBeginningTest() {
        String[] array = new String[]{"123", "456", "789", "apple", "banana"};
        String prefix = "1";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result);
    }

    @Test
    public void prefixAtEndTest() {
        String[] array = new String[]{"apple", "banana", "zebra", "zero", "zoo"};
        String prefix = "zo";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result);
    }

    @Test
    public void duplicateWordsTest() {
        String[] array = new String[]{"apple", "apple", "apple", "banana", "banana"};
        String prefix = "app";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(3, result); // Все три "apple"
    }

    @Test
    public void emptyPrefixTest() {
        String[] array = new String[]{"123", "Apple", "com", "combat", "computer", "data", "zebra", "zero", "zone", "zoo"};
        String prefix = "";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(10, result); // Все слова имеют пустой префикс
    }

    @Test
    public void prefixLongerThanSomeWordsTest() {
        String[] array = new String[]{"a", "ab", "abc", "abcd", "abcde"};
        String prefix = "abc";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(3, result); // "abc", "abcd", "abcde"
    }

    @Test
    public void numbersPrefixTest() {
        String[] array = new String[]{"123", "1234", "12345", "234", "345"};
        String prefix = "123";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(3, result); // "123", "1234", "12345"
    }

    @Test
    public void specialCharactersTest() {
        String[] array = new String[]{"@test", "#tag", "$money", "normal", "test"};
        String prefix = "test";
        int result = AlgorithmPrefixTask.startBinary(array, prefix);
        assertEquals(1, result); // Только "test" (не "@test")
    }
}