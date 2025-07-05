package org.example.Math;

import org.example.Math.string.AlgorithmCheckAnnogram;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmCheckAnnogramTest {

    @Test
    public void checkAnnogram() {
        assertTrue(AlgorithmCheckAnnogram.checkAnnogram("abc","cba"));
        assertTrue(AlgorithmCheckAnnogram.checkAnnogram("a","a"));
        assertTrue(AlgorithmCheckAnnogram.checkAnnogram("ab","ba"));
        assertTrue(AlgorithmCheckAnnogram.checkAnnogram("",""));
        assertFalse(AlgorithmCheckAnnogram.checkAnnogram("abc","abck"));
        assertFalse(AlgorithmCheckAnnogram.checkAnnogram("abc","yuo"));
    }
}