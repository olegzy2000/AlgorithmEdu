package org.example.Math.tree;

import org.example.Math.model.BTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BTreeAlgorithmTest {


    @Test
    public void simpleRoot() {
      int []array = {1,2};
      BTreeNode actual=BTreeAlgorithm.start(array,2);
      BTreeNode expected=new BTreeNode();
      expected.setCurrentKeys(new ArrayList<>(asList(1,2)));
      expected.setTreeDegree(2);
      expected.setRoot(true);
      assertEquals(expected,actual);
    }
    @Test
    public void simpleRoot2LevelDeep() {
        int []array = {1,2,3,4};

        BTreeNode actual=BTreeAlgorithm.start(array,2);

        BTreeNode expected=new BTreeNode();
        expected.getCurrentKeys().add(2);
        expected.setTreeDegree(2);
        expected.setRoot(true);

        BTreeNode leftNode=new BTreeNode();
        leftNode.setRoot(false);
        leftNode.setTreeDegree(2);
        leftNode.getCurrentKeys().add(1);

        BTreeNode rightNode=new BTreeNode();
        rightNode.setRoot(false);
        rightNode.setTreeDegree(2);
        rightNode.getCurrentKeys().addAll(asList(3,4));

        expected.getChildren().add(leftNode);
        expected.getChildren().add(rightNode);
        assertEquals(expected,actual);
    }


    @Test
    public void simpleRoot2LevelDeep3Children() {
        int []array = {1,2,3,4,5,6};

        BTreeNode actual=BTreeAlgorithm.start(array,2);
        BTreeNode expected=new BTreeNode();
        expected.getCurrentKeys().add(2);
        expected.setTreeDegree(2);
        expected.setRoot(true);

        BTreeNode leftNode=new BTreeNode();
        leftNode.setRoot(false);
        leftNode.setTreeDegree(2);
        leftNode.getCurrentKeys().add(1);
        leftNode.setParent(expected);

        BTreeNode rightNode=new BTreeNode();
        rightNode.setRoot(false);
        rightNode.setTreeDegree(2);
        rightNode.getCurrentKeys().addAll(asList(3,4));
        rightNode.setParent(expected);


        expected.getChildren().add(leftNode);
        expected.getChildren().add(rightNode);
        assertEquals(expected,actual);
    }

}