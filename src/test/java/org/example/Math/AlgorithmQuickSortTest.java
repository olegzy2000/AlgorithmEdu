package org.example.Math;

import org.example.Math.sort.nlogn.AlgorithmQuickSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AlgorithmQuickSortTest {

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testEmptyArray executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNullArray() {
        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(null);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testNullArray executed in %d ns%n", duration);
        assertNull(result);
    }

    @Test
    public void testSingleElementArray() {
        int[] input = {5};
        int[] expected = {5};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testSingleElementArray executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testAlreadySortedArray executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testReverseSortedArray executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnsortedArray() {
        int[] input = {3, 6, 1, 8, 2, 4};
        int[] expected = {1, 2, 3, 4, 6, 8};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testUnsortedArray executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] input = {4, 2, 4, 1, 2, 3};
        int[] expected = {1, 2, 2, 3, 4, 4};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testArrayWithDuplicates executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] input = {-3, 6, -1, 0, -2, 4};
        int[] expected = {-3, -2, -1, 0, 4, 6};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testArrayWithNegativeNumbers executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testLargeArray() {
        int[] input = new int[10_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 10_000);
        }
        int[] expected = input.clone();
        Arrays.sort(expected);

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testLargeArray (10,000 elements) executed in %d ms%n",
                TimeUnit.NANOSECONDS.toMillis(duration));
        assertArrayEquals(expected, result);
    }


    @Test
    public void testArrayWithAllEqualElements() {
        int[] input = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};

        long startTime = System.nanoTime();
        int[] result = AlgorithmQuickSort.quickSort(input);
        long duration = System.nanoTime() - startTime;

        System.out.printf("testArrayWithAllEqualElements executed in %d ns%n", duration);
        assertArrayEquals(expected, result);
    }


}