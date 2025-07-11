package org.example.Math.sort.nlogn;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class AlgorithmMergeSortTest {

    @Test
    public void testMergeDuplicates() {
        int[] input = { 8, 8, 8, 2, 2};
        int[] expected = {2, 2, 8, 8, 8};
        AlgorithmMergeSort.merge(input,0,2,3,4);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeHalfOfArray() {
        int[] input = { 10, 11, 4, 5, 6};
        int[] expected = {4, 5, 6, 10, 11};
        AlgorithmMergeSort.merge(input,0,1,2,4);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeHalfOfArraySorted() {
        int[] input = { 4, 5, 6,10, 11};
        int[] expected = {4, 5, 6, 10, 11};
        AlgorithmMergeSort.merge(input,0,2,3,4);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeTwoElementsSorted() {
        int[] input = { 4, 5};
        int[] expected = {4, 5};
        AlgorithmMergeSort.merge(input,0,0,1,1);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeTwoElements() {
        int[] input = { 5, 4};
        int[] expected = {4, 5};
        AlgorithmMergeSort.merge(input,0,0,1,1);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeBadIndexes() {
        int[] input = { 5, 4};
        int[] expected = {5, 4};
        AlgorithmMergeSort.merge(input,0,0,0,0);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeBadIndexesSameFirstStartAndSecondStart() {
        int[] input = { 5, 4};
        int[] expected = {5, 4};
        AlgorithmMergeSort.merge(input,0,1,1,1);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testMergeSubarrayTwoElements() {
        int[] input = { 3,5,8,1,2};
        int[] expected = {3,5,8,1,2};
        AlgorithmMergeSort.merge(input,3,3,4,4);
        assertArrayEquals(expected, input);
    }



    //-----------------------------------------------------------------------
    @Test
    public void testSmallArrayPerformance() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};

        long startTime = System.nanoTime();
        int[] result = AlgorithmMergeSort.mergeSort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime; // in nanoseconds
        System.out.println("Small array sort time (ns): " + duration);

        assertArrayEquals(expected, result);
    }



    @Test
    public void testLargeArrayPerformance() {
        int size = 100_000;
        int[] input = new int[size];
        Random rand = new Random(42); // fixed seed for reproducibility
        for (int i = 0; i < size; i++) {
            input[i] = rand.nextInt(size);
        }

        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        long startTime = System.nanoTime();
        int[] result = AlgorithmMergeSort.mergeSort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Large array sort time (ns): " + duration);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testAlreadySortedArrayPerformance() {
        int[] input = new int[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }

        int[] expected = Arrays.copyOf(input, input.length);

        long startTime = System.nanoTime();
        int[] result = AlgorithmMergeSort.mergeSort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Sorted array sort time (ns): " + duration);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testReversedArrayPerformance() {
        int[] input = new int[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = input.length - i;
        }

        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        long startTime = System.nanoTime();
        int[] result = AlgorithmMergeSort.mergeSort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Reversed array sort time (ns): " + duration);

        assertArrayEquals(expected, result);
    }
}