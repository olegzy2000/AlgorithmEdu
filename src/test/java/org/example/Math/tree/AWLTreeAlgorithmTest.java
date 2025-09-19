package org.example.Math.tree;

import org.example.Math.model.AWLTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class AWLTreeAlgorithmTest {

    @Test
    public void createTree() {
        AWLTreeNode root=AWLTreeAlgorithm.createTree(new int[]{5,4,9,3,10,7,6,1,-1,-2,11,12});
        System.out.println(AWLTreeAlgorithm.depthTraversal(root,0));
    }
}