package org.example.Math;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmCheckBracketSequenceTest {

    @Test
    public void checkSequenceUseBalance() {
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()()"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance("(())"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()(())"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance(""));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseBalance(null));

        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("("));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("())"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("(()"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()*"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()())"));
    }

    @Test
    public void checkSequenceUseStack() {
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack("()"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack("()()"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack("(())"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack("()(())"));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack(""));
        assertTrue(AlgorithmCheckBracketSequence.checkSequenceUseStack(null));


        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("("));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("())"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("(()"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()*"));
        assertFalse(AlgorithmCheckBracketSequence.checkSequenceUseBalance("()())"));
    }
}