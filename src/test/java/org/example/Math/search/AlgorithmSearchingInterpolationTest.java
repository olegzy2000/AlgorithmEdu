package org.example.Math.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmSearchingInterpolationTest {

    private final AlgorithmSearchingInterpolation search = new AlgorithmSearchingInterpolation();

    @Test
    public void testElementFoundWithTiming() {
        int[] arr = generateSortedArray(5_000); // Массив из 1 млн элементов: 0, 1, 2, ...
        int target = 2555;

        long start = System.nanoTime();
        int result = search.searchingInterpolation(arr, target);
        long duration = System.nanoTime() - start;

        System.out.println("Поиск элемента " + target + " занял " + duration + " наносекунд");

        assertEquals(target, result);
    }

    @Test
    public void testElementNotFoundWithTiming() {
        int[] arr = generateSortedArray(1_000_000);
        int target = 1_500_000;

        long start = System.nanoTime();
        int result = search.searchingInterpolation(arr, target);
        long duration = System.nanoTime() - start;

        System.out.println("Поиск отсутствующего элемента " + target + " занял " + duration + " наносекунд");

        assertEquals(-1, result);
    }

    @Test
    public void testSmallArrayTiming() {
        int[] arr = {5, 10, 15, 20, 25};
        int target = 15;

        long start = System.nanoTime();
        int result = search.searchingInterpolation(arr, target);
        long duration = System.nanoTime() - start;

        System.out.println("Поиск по маленькому массиву занял " + duration + " наносекунд");

        assertEquals(2, result);
    }

    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}