package org.example.Math.sort.nn;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AlgorithmInsertSortTest {

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }

    @Test
    public void testEmptyArray() {
        int[] input = {};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{}, result);
        System.out.printf("Empty array - Time: %,d ns%n", duration);
    }

    @Test
    public void testSingleElementArray() {
        int[] input = {5};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{5}, result);
        System.out.printf("Single element - Time: %,d ns%n", duration);
    }

    @Test
    public void testSortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
        System.out.printf("Already sorted (5 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
        System.out.printf("Reverse sorted (5 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testRandomArray() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 6, 9}, result);
        System.out.printf("Random array (8 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] input = {2, 2, 2, 1, 1, 3, 3, 3};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{1, 1, 2, 2, 2, 3, 3, 3}, result);
        System.out.printf("Array with duplicates (8 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] input = {-3, 1, -4, 1, -5, 9, -2, 6};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{-5, -4, -3, -2, 1, 1, 6, 9}, result);
        System.out.printf("Array with negatives (8 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testPartiallySortedArray() {
        int[] input = {1, 2, 3, 7, 4, 5, 6};
        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, result);
        System.out.printf("Partially sorted array (7 elements) - Time: %,d ns%n", duration);
    }

    @Test
    public void testLargeArray() {
        int size = 10000;
        int[] input = generateRandomArray(size);

        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        // Проверяем, что массив отсортирован
        for (int i = 0; i < result.length - 1; i++) {
            assertTrue(result[i] <= result[i + 1]);
        }
        System.out.printf("Large random array (%,d elements) - Time: %,.3f ms%n",
                size, duration / 1_000_000.0);
    }

    @Test
    public void testVeryLargeArray() {
        int size = 50000;
        int[] input = generateRandomArray(size);

        long startTime = System.nanoTime();
        int[] result = AlgorithmInsertSort.InsertSort(input);
        long duration = System.nanoTime() - startTime;

        // Проверяем, что массив отсортирован
        for (int i = 0; i < result.length - 1; i++) {
            assertTrue(result[i] <= result[i + 1]);
        }
        System.out.printf("Very large random array (%,d elements) - Time: %,.3f ms%n",
                size, duration / 1_000_000.0);
    }
}