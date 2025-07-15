package org.example.Math.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmBinarySearchTest {

    private int[] testArray;
    private AlgorithmBinarySearch searcher;
    @Before
    public void setUp() {
        searcher = new AlgorithmBinarySearch();
        testArray = new int[1_000_000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }
    }

    @Test
    public void testSearchFirstElement() {
        int target = 0;
        long start = System.nanoTime();
        int result = searcher.binarySearch(testArray, target);
        long end = System.nanoTime();
        System.out.printf("Search first element: %.3f ms%n", (end - start) / 1_000_000.0);

        assertEquals(0, result);
    }

    @Test
    public void testSearchMiddleElement() {
        int target = 500_000;
        long start = System.nanoTime();
        int result = searcher.binarySearch(testArray, target);
        long end = System.nanoTime();
        System.out.printf("Search middle element: %.3f ms%n", (end - start) / 1_000_000.0);

        assertEquals(500_000, result);
    }

    @Test
    public void testSearchLastElement() {
        int target = 999_999;
        long start = System.nanoTime();
        int result = searcher.binarySearch(testArray, target);
        long end = System.nanoTime();
        System.out.printf("Search last element: %.3f ms%n", (end - start) / 1_000_000.0);

        assertEquals(999_999, result);
    }

    @Test
    public void testSearchNotFoundLow() {
        int target = -10;
        long start = System.nanoTime();
        Integer result = searcher.binarySearch(testArray, target);
        long end = System.nanoTime();
        System.out.printf("Search not found (low): %.3f ms%n", (end - start) / 1_000_000.0);

        assertNull(result);
    }

    @Test
    public void testSearchNotFoundHigh() {
        int target = 1_000_010;
        long start = System.nanoTime();
        Integer result = searcher.binarySearch(testArray, target);
        long end = System.nanoTime();
        System.out.printf("Search not found (high): %.3f ms%n", (end - start) / 1_000_000.0);

        assertNull(result);
    }
}