package org.example.Math.combinatorics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationWithRepetitionTest {

    private CombinationWithRepetition generator;

    @Before
    public void setUp() {
        generator = new CombinationWithRepetition();
    }

    @Test
    public void testBasicFunctionality() {
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Verify that result is not null and not empty
        assertNotNull("Result should not be null", result);
        assertFalse("Result should not be empty", result.isEmpty());
    }

    @Test
    public void testCorrectNumberOfCombinations() {
        // For n=2, k=5: C(2+5-1,5) = C(6,5) = 6 combinations
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        assertEquals("Should generate exactly 6 combinations for 2 elements", 6, result.size());
    }

    @Test
    public void testThreeElements() {
        // For n=3, k=5: C(3+5-1,5) = C(7,5) = 21 combinations
        char[] array = {'A', 'B', 'C'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        assertEquals("Should generate 21 combinations for 3 elements", 21, result.size());
    }

    @Test
    public void testAllCombinationsHaveCorrectSize() {
        char[] array = {'A', 'B', 'C'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Verify that every combination has exactly 5 elements
        for (List<Character> combination : result) {
            assertEquals("Each combination must have exactly 5 elements", 5, combination.size());
        }
    }

    @Test
    public void testCombinationsContainOnlyValidElements() {
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Verify that all elements in combinations are from the original array
        for (List<Character> combination : result) {
            for (char element : combination) {
                assertTrue("All elements must be from the original array",
                        element == 'A' || element == 'B');
            }
        }
    }

    @Test
    public void testNoDuplicateCombinations() {
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Verify that all combinations are unique (no duplicates)
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                assertNotEquals("All combinations must be unique",
                        result.get(i), result.get(j));
            }
        }
    }

    @Test
    public void testSpecificCombinationsExist() {
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Test that specific expected combinations are present in the result
        List<Character> allA = createList('A', 'A', 'A', 'A', 'A');
        List<Character> allB = createList('B', 'B', 'B', 'B', 'B');
        List<Character> mixed = createList('A', 'A', 'A', 'A', 'B');

        assertTrue("Should contain combination with all A's", containsCombination(result, allA));
        assertTrue("Should contain combination with all B's", containsCombination(result, allB));
        assertTrue("Should contain mixed combination", containsCombination(result, mixed));
    }

    @Test
    public void testSingleElementArray() {
        // For n=1, k=5: C(1+5-1,5) = C(5,5) = 1 combination
        char[] array = {'A'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        assertEquals("Should generate exactly 1 combination for single element", 1, result.size());
        assertEquals("The only combination should contain five A's",
                createList('A', 'A', 'A', 'A', 'A'), result.get(0));
    }

    @Test
    public void testEmptyArray() {
        // Edge case: empty input array
        char[] array = {};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Should return empty list since no combinations can be formed
        assertNotNull("Result should not be null for empty array", result);
        assertTrue("Result should be empty for empty array", result.isEmpty());
    }

    @Test
    public void testOrderWithinCombinations() {
        char[] array = {'A', 'B'};
        List<List<Character>> result = CombinationWithRepetition.start(array);

        // Verify that combinations are generated in lexicographical order
        // This tests the algorithm's specific behavior
        for (int i = 0; i < result.size() - 1; i++) {
            List<Character> current = result.get(i);
            List<Character> next = result.get(i + 1);

            // Current combination should be lexicographically less than or equal to next
            assertTrue("Combinations should be in non-decreasing order",
                    isLexicographicallyOrdered(current, next));
        }
    }

    // Helper method to create a list of characters
    private List<Character> createList(char... chars) {
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }
        return list;
    }

    // Helper method to check if a combination exists in the result list
    private boolean containsCombination(List<List<Character>> result, List<Character> target) {
        for (List<Character> combination : result) {
            if (combination.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check lexicographical order
    private boolean isLexicographicallyOrdered(List<Character> first, List<Character> second) {
        for (int i = 0; i < first.size(); i++) {
            if (first.get(i) < second.get(i)) {
                return true;
            } else if (first.get(i) > second.get(i)) {
                return false;
            }
        }
        return true; // Lists are equal
    }
}