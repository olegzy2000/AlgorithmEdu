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
        int []array = {1,3,5,7,9,11,-1,4};

        BTreeNode actual=BTreeAlgorithm.start(array,2);
        BTreeNode expected=new BTreeNode();
        expected.addNewKey(3);
        expected.addNewKey(7);
        expected.setTreeDegree(2);
        expected.setRoot(true);

        BTreeNode firstChild=new BTreeNode();
        firstChild.setRoot(false);
        firstChild.setTreeDegree(2);
        firstChild.addNewKey(-1);
        firstChild.addNewKey(1);
        firstChild.setParent(expected);

        BTreeNode secondChild=new BTreeNode();
        secondChild.setRoot(false);
        secondChild.setTreeDegree(2);
        secondChild.addNewKey(5);
        secondChild.addNewKey(4);
        secondChild.setParent(expected);

        BTreeNode thirdChild=new BTreeNode();
        thirdChild.setRoot(false);
        thirdChild.setTreeDegree(2);
        thirdChild.addListKey(asList(9,11));
        thirdChild.setParent(expected);


        expected.getChildren().add(firstChild);
        expected.getChildren().add(secondChild);
        expected.getChildren().add(thirdChild);
        assertEquals(expected,actual);
    }

    @Test
    public void simpleRoot2LevelDeep4Children() {
        int []array = {1,2,3,4,5,6,7,8};

        BTreeNode actual=BTreeAlgorithm.start(array,2);
        BTreeNode expected=new BTreeNode();
        expected.addNewKey(2);
        expected.addNewKey(4);
        expected.addNewKey(6);
        expected.setTreeDegree(2);
        expected.setRoot(true);

        BTreeNode firstChild=new BTreeNode();
        firstChild.setRoot(false);
        firstChild.setTreeDegree(2);
        firstChild.addNewKey(1);
        firstChild.setParent(expected);

        BTreeNode secondChild=new BTreeNode();
        secondChild.setRoot(false);
        secondChild.setTreeDegree(2);
        secondChild.addNewKey(3);
        secondChild.setParent(expected);

        BTreeNode thirdChild=new BTreeNode();
        thirdChild.setRoot(false);
        thirdChild.setTreeDegree(2);
        thirdChild.addNewKey(5);
        thirdChild.setParent(expected);

        BTreeNode foursChild=new BTreeNode();
        foursChild.setRoot(false);
        foursChild.setTreeDegree(2);
        foursChild.addListKey(asList(7,8));
        foursChild.setParent(expected);


        expected.getChildren().add(firstChild);
        expected.getChildren().add(secondChild);
        expected.getChildren().add(thirdChild);
        expected.getChildren().add(foursChild);
        assertEquals(expected,actual);
    }
    @Test
    public void searchNodeByKeysNull(){
        assertEquals(-1,BTreeAlgorithm.searchNodeByKeys(null,-1));
    }
    @Test
    public void searchNodeByKeysZeroIndex(){
        assertEquals(0,BTreeAlgorithm.searchNodeByKeys(asList(1,3),0));
    }
    @Test
    public void searchNodeByKeysMiddleIndex(){
        assertEquals(1,BTreeAlgorithm.searchNodeByKeys(asList(1,3),2));
    }
    @Test
    public void searchNodeByKeysMaxIndex(){
        assertEquals(2,BTreeAlgorithm.searchNodeByKeys(asList(1,3),5));
    }
}