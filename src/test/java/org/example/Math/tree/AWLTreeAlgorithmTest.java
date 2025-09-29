package org.example.Math.tree;

import org.example.Math.model.AWLTreeNode;
import org.junit.Assert;
import org.junit.Test;

public class AWLTreeAlgorithmTest {

    @Test
    public void createTreeSimpleLeftRotation() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{4,7,8,9});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{7,4,8,9});
        Assert.assertEquals(expected,root);
    }
    @Test
    public void createTreeSimpleRightRotation() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{4,3,2,1});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{3,2,4,1});
        Assert.assertEquals(expected,root);
    }


    @Test
    public void createTreeWithLeftRightRotation() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{10, 5, 7});
        AWLTreeNode expected = AWLTreeAlgorithm.createTree(new int[]{7, 5, 10});
        Assert.assertEquals(expected, root);
    }

    @Test
    public void createTreeWithRightLeftRotation() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{10, 15, 16});
        AWLTreeNode expected = AWLTreeAlgorithm.createTree(new int[]{15, 10, 16});
        Assert.assertEquals(expected, root);
    }
    @Test
    public void leftRotationSimple() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{1,2,3});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,3});
        Assert.assertEquals(expected,root);
    }
    @Test
    public void rightRotationSimple() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{3,2,1});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,3});
        Assert.assertEquals(expected,root);
    }
    @Test
    public void leftRotationDifficultFrom3To2() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{2,3,1,4,5,});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{2,1,4,3,5});
        Assert.assertEquals(expected,root);
    }
    @Test
    public void leftRotationDifficultFrom4To3() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{2,1,4,3,5,6});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{4,2,3,1,5,6});
        root=AWLTreeAlgorithm.rotateLeft(root);
        Assert.assertEquals(expected,root);
    }
    @Test
    public void rightRotationDifficultFrom3To2() {
        AWLTreeNode root = AWLTreeAlgorithm.createTree(new int[]{-1,-2,1,-3,-4});
        AWLTreeNode newLeftNode=AWLTreeAlgorithm.rotateRight(root.getLeftChild());
        root.setLeftChild(newLeftNode);
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{-1,-3,-4,-2,1});
        Assert.assertEquals(expected,root);
    }
    @Test
    public void rightRotationDifficultFrom4To3() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{-2,-1,-4,-3,-5,-6});
        AWLTreeNode expected=AWLTreeAlgorithm.createTree(new int[]{-4,-2,-1,-3,-5,-6});
        root=AWLTreeAlgorithm.rotateRight(root);
        Assert.assertEquals(expected,root);
    }
}