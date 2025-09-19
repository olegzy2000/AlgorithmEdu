package org.example.Math.tree;

import org.example.Math.model.AWLTreeNode;

public class AWLTreeAlgorithm {
    public static AWLTreeNode createTree(int arrayNodes[]){
        AWLTreeNode root = new AWLTreeNode();
        root.setValue(arrayNodes[0]);
        for (int i = 1; i < arrayNodes.length; i++) {
            addNode(root,arrayNodes[i]);
        }
        return root;
    }
    private static void addNode(AWLTreeNode currentNode, int newValue) {
        if(currentNode.getValue() > newValue){
            if(currentNode.getLeftChild() != null){
                addNode(currentNode.getLeftChild(),newValue);
            }
            else{
                AWLTreeNode newNode = new AWLTreeNode();
                newNode.setValue(newValue);
                currentNode.setLeftChild(newNode);

            }
            return;
        }
        if(currentNode.getValue() <= newValue){
            if(currentNode.getRightChild() != null){
                addNode(currentNode.getRightChild(),newValue);
            }
            else{
                AWLTreeNode newNode = new AWLTreeNode();
                newNode.setValue(newValue);
                currentNode.setRightChild(newNode);
            }
        }
    }
    private static int calculateBalance(AWLTreeNode root) {
       int balance = 0;
       return balance;
    }
    public static int depthTraversal(AWLTreeNode root, int newDepth) {
       if(root == null)
           return newDepth;
       int heightLeft = newDepth;
       int heightRight = newDepth;
       if(root.getRightChild() != null)
           heightRight=depthTraversal(root.getRightChild(), newDepth+1);
       if(root.getLeftChild() != null)
           heightLeft=depthTraversal(root.getLeftChild(), newDepth+1);
        return heightRight>heightLeft?heightRight:heightLeft;
    }

    private static void rotateRightRight(AWLTreeNode currentNode){

    }
    private static void rotateRightLeft(AWLTreeNode currentNode){

    }
    private static void rotateLeftLeft(AWLTreeNode currentNode){

    }
    private static void rotateLeftRight(AWLTreeNode currentNode){

    }
}
