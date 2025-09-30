package org.example.Math.tree;

import org.example.Math.model.AWLTreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AWLTreeAlgorithmTest {

    @Test
    public void createTreeWithLeftRightRotation() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{10, 5, 7});
        AWLTreeNode expected = AWLTreeAlgorithm.createTree(new int[]{7, 5, 10});
        assertEquals(expected, root);
    }

    @Test
    public void createTreeWithRightLeftRotation() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{10, 15, 16});
        AWLTreeNode expected = AWLTreeAlgorithm.createTree(new int[]{15, 10, 16});
        assertEquals(expected, root);
    }
    @Test
    public void leftRotationSimple() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{1,2,3});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,3});
        assertEquals(expected,root);
    }
    @Test
    public void rightRotationSimple() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{3,2,1});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,3});
        assertEquals(expected,root);
    }

    @Test
    public void createTreeSimpleLeftRotation() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{4,7,8,9});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{7,4,8,9});
        assertEquals(expected,root);
    }
    @Test
    public void createTreeSimpleRightRotation() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{4,3,2,1});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{3,2,4,1});
        assertEquals(expected,root);
    }

    @Test
    public void leftRotationDifficultFrom3To2() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{2,3,1,4,5,});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,4,3,5});
        assertEquals(expected,root);
    }
    @Test
    public void leftRotationDifficultFrom4To3() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{2,1,4,3,5,6});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{4,5,6,2,1,3});
        assertEquals(expected,root);
    }
    @Test
    public void rightRotationDifficultFrom3To2() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{-1,-2,1,-3,-4});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{-1,-3,1,-2,-4});
        assertEquals(expected,root);
    }
    @Test
    public void rightRotationDifficultFrom4To3() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{-2,-1,-4,-3,-5,-6});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{-4,-2,-5,-3,-1,-6});
        assertEquals(expected,root);
    }






    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createTreeFromEmptyArrayThrows() {
        // Implementation reads arrayNodes[0], so empty input must throw.
        AWLTreeAlgorithm.createTree(new int[]{});
    }

    @Test
    public void createTreeFromSingleElementBuildsLeaf() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{42});
        // Single node should be created properly
        assertNotNull(root);
        assertEquals(42, root.getValue());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        // Single node is balanced
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
    }

    // ---------------- Classic rotations via insertions ----------------
    // (names are generic; concrete sequences are only inside the test body)

    @Test
    public void rightHeavyChainIsBalancedByRotation() {
        // Strictly increasing inserts trigger a right-heavy chain that must be fixed by a left rotation.
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{1, 2, 3});
        // Expect root to be the middle key; children the extremes
        assertEquals(2, root.getValue());
        assertEquals(1, root.getLeftChild().getValue());
        assertEquals(3, root.getRightChild().getValue());
        // Spot-check balances
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
    }

    @Test
    public void leftHeavyChainIsBalancedByRotation() {
        // Strictly decreasing inserts trigger a left-heavy chain that must be fixed by a right rotation.
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{3, 2, 1});
        assertEquals(2, root.getValue());
        assertEquals(1, root.getLeftChild().getValue());
        assertEquals(3, root.getRightChild().getValue());
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
    }

    @Test
    public void leftRightImbalanceIsResolved() {
        // Pattern that creates an LR case (left-right).
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{30, 10, 20});
        // Middle key should become root; smaller to the left; larger to the right.
        assertEquals(20, root.getValue());
        assertEquals(10, root.getLeftChild().getValue());
        assertEquals(30, root.getRightChild().getValue());
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
    }

    @Test
    public void rightLeftImbalanceIsResolved() {
        // Pattern that creates an RL case (right-left).
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{10, 30, 20});
        assertEquals(20, root.getValue());
        assertEquals(10, root.getLeftChild().getValue());
        assertEquals(30, root.getRightChild().getValue());
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
    }

    // ---------------- Duplicates & mixed data ----------------



    @Test
    public void ascendingInsertionsRemainBalanced() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{1,2,3,4,5,6,7,8,9});
        // Check only local balances (no helpers)
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        if (root.getLeftChild() != null) {
            assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        }
        if (root.getRightChild() != null) {
            assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
        }
    }

    @Test
    public void mixedNegativeAndPositiveValuesRemainBalanced() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{0, -10, -20, 10, 20, 15, -5, 5});
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        if (root.getLeftChild() != null) {
            assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        }
        if (root.getRightChild() != null) {
            assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
        }
    }

    // ---------------- Explicit shape check for a non-trivial sequence ----------------

    @Test
    public void sequenceProducesExpectedBalancedShape() {
        // Sequence from the discussion that ends up with a clear, well-formed balanced tree.
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{2, 1, 4, 3, 5, 6});

        // Expected shape:
        //         4
        //       /   \
        //      2     5
        //     / \     \
        //    1   3     6
        assertEquals(4, root.getValue());

        assertNotNull(root.getLeftChild());
        assertEquals(2, root.getLeftChild().getValue());
        assertNotNull(root.getLeftChild().getLeftChild());
        assertEquals(1, root.getLeftChild().getLeftChild().getValue());
        assertNotNull(root.getLeftChild().getRightChild());
        assertEquals(3, root.getLeftChild().getRightChild().getValue());

        assertNotNull(root.getRightChild());
        assertEquals(5, root.getRightChild().getValue());
        assertNull(root.getRightChild().getLeftChild());
        assertNotNull(root.getRightChild().getRightChild());
        assertEquals(6, root.getRightChild().getRightChild().getValue());

        // Spot-check balances
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root)) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getLeftChild())) <= 1);
        assertTrue(Math.abs(AWLTreeAlgorithm.calculateBalance(root.getRightChild())) <= 1);
    }

    // ---------------- Balance and height semantics on a tiny perfect tree ----------------

    @Test
    public void balanceAndHeightOnPerfectThreeNodeTree() {
        // Perfect small tree:   2
        //                      / \
        //                     1   3
        AWLTreeNode n1 = new AWLTreeNode(); n1.setValue(1);
        AWLTreeNode n3 = new AWLTreeNode(); n3.setValue(3);
        AWLTreeNode n2 = new AWLTreeNode(); n2.setValue(2);
        n2.setLeftChild(n1);
        n2.setRightChild(n3);

        // For a perfect tree, balance at root is zero; leaves also zero
        assertEquals(0, AWLTreeAlgorithm.calculateBalance(n2));
        assertEquals(0, AWLTreeAlgorithm.calculateBalance(n1));
        assertEquals(0, AWLTreeAlgorithm.calculateBalance(n3));

        // depthTraversal semantics: starting from 0, height of leaf is 1; root here is 2
        assertEquals(1, AWLTreeAlgorithm.depthTraversal(n1, 0));
        assertEquals(2, AWLTreeAlgorithm.depthTraversal(n2, 0));
    }



}