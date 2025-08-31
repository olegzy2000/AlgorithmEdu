package org.example.Math.chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicHourseTest {
    @Test
    public void test5x5Board() {
        // Measure the time for solving 5x5 board
        long start = System.nanoTime();
        boolean result = ClassicHourse.start(5, 0, 0);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.printf("5x5 board solved in %d ms%n", durationMs);

        assertTrue("Solution should exist for 5x5 board", result);
    }

    @Test
    public void test6x6Board() {
        long start = System.nanoTime();
        boolean result = ClassicHourse.start(6, 0, 0);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.printf("6x6 board solved in %d ms%n", durationMs);

        assertTrue("Solution should exist for 6x6 board", result);
    }

    @Test
    public void test8x8Board() {
        long start = System.nanoTime();
        boolean result = ClassicHourse.start(8, 0, 0);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.printf("8x8 board solved in %d ms%n", durationMs);

        assertTrue("Solution should exist for 8x8 board", result);
    }

    @Test
    public void test3x3Board() {
        long start = System.nanoTime();
        boolean result = ClassicHourse.start(3, 0, 0);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.printf("3x3 board solved in %d ms%n", durationMs);

        assertFalse("No solution exists for 3x3 board", result);
    }

    @Test
    public void test4x4Board() {
        long start = System.nanoTime();
        boolean result = ClassicHourse.start(4, 0, 0);
        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000;

        System.out.printf("4x4 board solved in %d ms%n", durationMs);

        assertFalse("No solution exists for 4x4 board", result);
    }

    // --- Test multiple starting positions on the classic 8x8 board ---
    @Test
    public void test8x8DifferentStarts() {
        int[][] startPositions = {
                {0, 0}, {7, 7}, {0, 7}, {7, 0},
                {3, 3}, {4, 4}, {2, 5}, {5, 2}
        };

        for (int[] pos : startPositions) {
            long start = System.nanoTime();
            boolean result = ClassicHourse.start(8, pos[0], pos[1]);
            long end = System.nanoTime();
            long durationMs = (end - start) / 1_000_000;

            System.out.printf("8x8 board, start=(%d,%d) solved in %d ms%n",
                    pos[0], pos[1], durationMs);

            assertTrue("A solution should always exist for 8x8 board", result);
        }
    }
}