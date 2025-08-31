package org.example.Math.combinatorics;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CombinationWithoutRepetitionTest {

    private char[] testArray;
    private long startTime;

    @Before
    public void setUp() {
        // Reset timer before each test
        startTime = System.currentTimeMillis();
    }

    private void logExecutionTime(String testName, int inputSize, int sequenceSize, int resultCount) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(String.format(
                "Test: %s | Input: %d chars | Sequence: %d | Results: %d | Time: %d ms",
                testName, inputSize, sequenceSize, resultCount, duration
        ));
    }

    // Test Case 1: Basic functionality with small input
    @Test
    public void testBasicFunctionality() {
        System.out.println("=== Testing Basic Functionality ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Expected combinations without repetition: AB, AC, BC
        assertEquals("Result size should be 3", 3, result.size());

        Set<List<Character>> resultSet = new HashSet<>(result);
        assertTrue("Should contain AB", resultSet.contains(Arrays.asList('A', 'B')));
        assertTrue("Should contain AC", resultSet.contains(Arrays.asList('A', 'C')));
        assertTrue("Should contain BC", resultSet.contains(Arrays.asList('B', 'C')));

        // Verify no repetitions
        for (List<Character> combination : result) {
            Set<Character> uniqueChars = new HashSet<>(combination);
            assertEquals("Each combination should have unique characters", sequenceSize, uniqueChars.size());
        }

        logExecutionTime("BasicFunctionality", testArray.length, sequenceSize, result.size());
    }

    // Test Case 2: Single character input
    @Test
    public void testSingleCharacterInput() {
        System.out.println("=== Testing Single Character Input ===");
        testArray = new char[]{'X'};
        int sequenceSize = 1;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        assertEquals("Should have exactly one combination", 1, result.size());
        assertEquals("Should contain only X", Arrays.asList('X'), result.get(0));

        logExecutionTime("SingleCharacter", testArray.length, sequenceSize, result.size());
    }

    // Test Case 3: Sequence size larger than array length
    @Test
    public void testSequenceSizeLargerThanArray() {
        System.out.println("=== Testing Sequence Size > Array Length ===");
        testArray = new char[]{'A', 'B'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Should return empty list since we can't choose 3 unique from 2
        assertTrue("Should return empty list", result.isEmpty());

        logExecutionTime("LargeSequence", testArray.length, sequenceSize, result.size());
    }

    // Test Case 4: Empty input array
    @Test
    public void testEmptyInputArray() {
        System.out.println("=== Testing Empty Input Array ===");
        testArray = new char[]{};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        assertTrue("Should return empty list for empty input", result.isEmpty());

        logExecutionTime("EmptyInput", testArray.length, sequenceSize, result.size());
    }

    // Test Case 5: Sequence size equals array length
    @Test
    public void testSequenceSizeEqualsArrayLength() {
        System.out.println("=== Testing Sequence Size = Array Length ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Should return exactly one combination: ABC
        assertEquals("Should have exactly one combination", 1, result.size());
        assertEquals("Should contain ABC", Arrays.asList('A', 'B', 'C'), result.get(0));

        logExecutionTime("SequenceEqualsArray", testArray.length, sequenceSize, result.size());
    }

    // Test Case 6: Verify no duplicates in results
    @Test
    public void testNoDuplicateCombinations() {
        System.out.println("=== Testing No Duplicate Combinations ===");
        testArray = new char[]{'A', 'B', 'C', 'D'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Convert to set to check for duplicates
        Set<List<Character>> uniqueCombinations = new HashSet<>(result);

        assertEquals("Should have no duplicate combinations", result.size(), uniqueCombinations.size());

        logExecutionTime("NoDuplicates", testArray.length, sequenceSize, result.size());
    }

    // Test Case 7: Verify no character repetition within combinations
    @Test
    public void testNoCharacterRepetition() {
        System.out.println("=== Testing No Character Repetition ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        for (List<Character> combination : result) {
            Set<Character> uniqueChars = new HashSet<>(combination);
            assertEquals("Each combination should have unique characters", combination.size(), uniqueChars.size());
        }

        logExecutionTime("NoCharacterRepetition", testArray.length, sequenceSize, result.size());
    }

    // Test Case 8: Performance test with medium input
    @Test
    public void testMediumInputPerformance() {
        System.out.println("=== Testing Medium Input Performance ===");
        testArray = new char[]{'A', 'B', 'C', 'D', 'E'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Verify result count using combination formula: C(n, k)
        int expectedSize = calculateExpectedSize(testArray.length, sequenceSize);
        assertEquals("Result count should match combination formula", expectedSize, result.size());

        logExecutionTime("MediumPerformance", testArray.length, sequenceSize, result.size());
    }

    // Test Case 9: Four characters with sequence size 2
    @Test
    public void testFourCharactersSizeTwo() {
        System.out.println("=== Testing Four Characters with Sequence Size 2 ===");
        testArray = new char[]{'W', 'X', 'Y', 'Z'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Expected: WX, WY, WZ, XY, XZ, YZ
        assertEquals("Should generate 6 combinations", 6, result.size());

        Set<List<Character>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList('W', 'X'),
                Arrays.asList('W', 'Y'),
                Arrays.asList('W', 'Z'),
                Arrays.asList('X', 'Y'),
                Arrays.asList('X', 'Z'),
                Arrays.asList('Y', 'Z')
        ));

        assertEquals("Should contain all expected combinations", expected, new HashSet<>(result));

        logExecutionTime("FourCharsSizeTwo", testArray.length, sequenceSize, result.size());
    }

    // Test Case 10: Numeric characters input
    @Test
    public void testNumericCharacters() {
        System.out.println("=== Testing Numeric Characters ===");
        testArray = new char[]{'1', '2', '3'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        assertEquals("Should generate 3 combinations", 3, result.size());

        Set<List<Character>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList('1', '2'),
                Arrays.asList('1', '3'),
                Arrays.asList('2', '3')
        ));

        assertEquals("Should contain all expected numeric combinations", expected, new HashSet<>(result));

        logExecutionTime("NumericChars", testArray.length, sequenceSize, result.size());
    }

    // Test Case 11: Verify lexicographical order
    @Test
    public void testLexicographicalOrder() {
        System.out.println("=== Testing Lexicographical Order ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Should be in order: AB, AC, BC
        List<List<Character>> expectedOrder = Arrays.asList(
                Arrays.asList('A', 'B'),
                Arrays.asList('A', 'C'),
                Arrays.asList('B', 'C')
        );

        assertEquals("Should be in lexicographical order", expectedOrder, result);

        logExecutionTime("LexOrder", testArray.length, sequenceSize, result.size());
    }

    // Test Case 12: Sequence size of 0
    @Test
    public void testSequenceSizeZero() {
        System.out.println("=== Testing Sequence Size = 0 ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 0;

        List<List<Character>> result = CombinationWithoutRepetition.start(testArray, sequenceSize);

        // Should return list with one empty combination
        assertEquals("Should have one empty combination", 1, result.size());
        assertTrue("Should contain empty list", result.get(0).isEmpty());

        logExecutionTime("SequenceSizeZero", testArray.length, sequenceSize, result.size());
    }

    // Helper method to calculate expected number of combinations without repetition
    private int calculateExpectedSize(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0) return 1;
        // Formula: C(n, k) = n! / (k! * (n-k)!)
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private int factorial(int number) {
        if (number <= 1) return 1;
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}