package org.example.Math.combinatorics;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CombinationWithRepetitionTest {
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
        testArray = new char[]{'A', 'B'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        // Expected combinations with repetition: AA, AB, BB
        assertEquals("Result size should be 3", 3, result.size());

        Set<List<Character>> resultSet = new HashSet<>(result);
        assertTrue("Should contain AA", resultSet.contains(Arrays.asList('A', 'A')));
        assertTrue("Should contain AB", resultSet.contains(Arrays.asList('A', 'B')));
        assertTrue("Should contain BB", resultSet.contains(Arrays.asList('B', 'B')));

        logExecutionTime("BasicFunctionality", testArray.length, sequenceSize, result.size());
    }

    // Test Case 2: Single character input
    @Test
    public void testSingleCharacterInput() {
        System.out.println("=== Testing Single Character Input ===");
        testArray = new char[]{'X'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        assertEquals("Should have exactly one combination", 1, result.size());
        assertEquals("Should contain only XXX", Arrays.asList('X', 'X', 'X'), result.get(0));

        logExecutionTime("SingleCharacter", testArray.length, sequenceSize, result.size());
    }

    // Test Case 3: Sequence size of 1
    @Test
    public void testSequenceSizeOne() {
        System.out.println("=== Testing Sequence Size = 1 ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 1;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        assertEquals("Should have same size as input array", testArray.length, result.size());

        Set<List<Character>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList('A'),
                Arrays.asList('B'),
                Arrays.asList('C')
        ));

        assertEquals("Should contain all individual characters", expected, new HashSet<>(result));

        logExecutionTime("SequenceSizeOne", testArray.length, sequenceSize, result.size());
    }

    // Test Case 4: Empty input array
    @Test
    public void testEmptyInputArray() {
        System.out.println("=== Testing Empty Input Array ===");
        testArray = new char[]{};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        assertTrue("Should return empty list for empty input", result.isEmpty());

        logExecutionTime("EmptyInput", testArray.length, sequenceSize, result.size());
    }

    // Test Case 5: Sequence size larger than array length
    @Test
    public void testSequenceSizeLargerThanArray() {
        System.out.println("=== Testing Sequence Size > Array Length ===");
        testArray = new char[]{'A', 'B'};
        int sequenceSize = 4;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        assertTrue("Should generate combinations", result.size() > 0);

        Set<Character> validChars = new HashSet<>(Arrays.asList('A', 'B'));

        for (List<Character> combination : result) {
            assertEquals("Each combination should have correct size", sequenceSize, combination.size());

            // Check that all characters are from the input array
            for (Character c : combination) {
                assertTrue("Character should be from input array", validChars.contains(c));
            }
        }

        logExecutionTime("LargeSequence", testArray.length, sequenceSize, result.size());
    }

    // Test Case 6: Verify no duplicates in results
    @Test
    public void testNoDuplicateCombinations() {
        System.out.println("=== Testing No Duplicate Combinations ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        // Convert to set to check for duplicates
        Set<List<Character>> uniqueCombinations = new HashSet<>(result);

        assertEquals("Should have no duplicate combinations", result.size(), uniqueCombinations.size());

        logExecutionTime("NoDuplicates", testArray.length, sequenceSize, result.size());
    }

    // Test Case 7: Performance test with medium input
    @Test
    public void testMediumInputPerformance() {
        System.out.println("=== Testing Medium Input Performance ===");
        testArray = new char[]{'A', 'B', 'C', 'D', 'E'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        // Verify result count using combination with repetition formula: C(n+k-1, k)
        int expectedSize = calculateExpectedSize(testArray.length, sequenceSize);
        assertEquals("Result count should match combination formula", expectedSize, result.size());

        logExecutionTime("MediumPerformance", testArray.length, sequenceSize, result.size());
    }

    // Test Case 8: Three characters with sequence size 2
    @Test
    public void testThreeCharactersSizeTwo() {
        System.out.println("=== Testing Three Characters with Sequence Size 2 ===");
        testArray = new char[]{'X', 'Y', 'Z'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        // Expected: XX, XY, XZ, YY, YZ, ZZ
        assertEquals("Should generate 6 combinations", 6, result.size());

        Set<List<Character>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList('X', 'X'),
                Arrays.asList('X', 'Y'),
                Arrays.asList('X', 'Z'),
                Arrays.asList('Y', 'Y'),
                Arrays.asList('Y', 'Z'),
                Arrays.asList('Z', 'Z')
        ));

        assertEquals("Should contain all expected combinations", expected, new HashSet<>(result));

        logExecutionTime("ThreeCharsSizeTwo", testArray.length, sequenceSize, result.size());
    }

    // Test Case 9: Numeric characters input
    @Test
    public void testNumericCharacters() {
        System.out.println("=== Testing Numeric Characters ===");
        testArray = new char[]{'1', '2', '3'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        assertTrue("Should generate combinations", result.size() > 0);

        Set<Character> validChars = new HashSet<>(Arrays.asList('1', '2', '3'));
        for (List<Character> combination : result) {
            assertEquals("Combination should have correct size", sequenceSize, combination.size());
            for (Character c : combination) {
                assertTrue("All characters should be valid numbers", validChars.contains(c));
            }
        }

        logExecutionTime("NumericChars", testArray.length, sequenceSize, result.size());
    }

    // Test Case 10: Mixed case characters
    @Test
    public void testMixedCaseCharacters() {
        System.out.println("=== Testing Mixed Case Characters ===");
        testArray = new char[]{'a', 'B', 'c', 'D'};
        int sequenceSize = 2;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        Set<Character> validChars = new HashSet<>(Arrays.asList('a', 'B', 'c', 'D'));
        for (List<Character> combination : result) {
            assertEquals("Combination should have correct size", sequenceSize, combination.size());
            for (Character c : combination) {
                assertTrue("All characters should be from input", validChars.contains(c));
            }
        }

        logExecutionTime("MixedCase", testArray.length, sequenceSize, result.size());
    }

    // Test Case 11: Maximum sequence size
    @Test
    public void testMaximumSequenceSize() {
        System.out.println("=== Testing Maximum Sequence Size ===");
        testArray = new char[]{'A', 'B', 'C'};
        int sequenceSize = 5;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        int expectedSize = calculateExpectedSize(testArray.length, sequenceSize);
        assertEquals("Result count should match combination formula", expectedSize, result.size());

        logExecutionTime("MaxSequence", testArray.length, sequenceSize, result.size());
    }

    // Test Case 12: Verify all combinations have correct size
    @Test
    public void testAllCombinationsHaveCorrectSize() {
        System.out.println("=== Testing All Combinations Have Correct Size ===");
        testArray = new char[]{'A', 'B', 'C', 'D'};
        int sequenceSize = 3;

        List<List<Character>> result = CombinationWithRepetition.start(testArray, sequenceSize);

        for (List<Character> combination : result) {
            assertEquals("Each combination should have size " + sequenceSize, sequenceSize, combination.size());
        }

        logExecutionTime("CorrectSize", testArray.length, sequenceSize, result.size());
    }

    // Helper method to calculate expected number of combinations with repetition
    private int calculateExpectedSize(int n, int k) {
        // Formula: C(n+k-1, k) = (n+k-1)! / (k! * (n-1)!)
        return factorial(n + k - 1) / (factorial(k) * factorial(n - 1));
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