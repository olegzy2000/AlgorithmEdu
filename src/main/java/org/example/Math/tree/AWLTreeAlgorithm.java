package org.example.Math.tree;

import org.example.Math.model.AWLTreeNode;

public class AWLTreeAlgorithm {
    public static AWLTreeNode createTree(int arrayNodes[]){
        AWLTreeNode root = new AWLTreeNode();
        root.setValue(arrayNodes[0]);
        for (int i = 1; i < arrayNodes.length; i++) {
            root=addNode(root,arrayNodes[i]);
        }
        return root;
    }
    private static AWLTreeNode addNode(AWLTreeNode currentNode, int newValue) {
        if(currentNode.getValue() > newValue){
            if(currentNode.getLeftChild() != null){
                addNode(currentNode.getLeftChild(),newValue);
            }
            else{
                AWLTreeNode newNode = new AWLTreeNode();
                newNode.setValue(newValue);
                currentNode.setLeftChild(newNode);
            }
        }
        else if(currentNode.getValue() <= newValue){
            if(currentNode.getRightChild() != null){
                addNode(currentNode.getRightChild(),newValue);
            }
            else{
                AWLTreeNode newNode = new AWLTreeNode();
                newNode.setValue(newValue);
                currentNode.setRightChild(newNode);
            }
        }
        rebalanceTree(currentNode);
        return currentNode;
    }

    private static void rebalanceTree(AWLTreeNode currentNode) {
        int leftNodeBalance=calculateBalance(currentNode.getLeftChild());

        if(leftNodeBalance<-1){
            AWLTreeNode newLeftNode=rotateLeft(currentNode.getLeftChild());
            currentNode.setLeftChild(newLeftNode);
        }
        else if(leftNodeBalance>1){
            AWLTreeNode newLeftNode=rotateRight(currentNode.getLeftChild());
            currentNode.setLeftChild(newLeftNode);
        }

        int rightNodeBalance=calculateBalance(currentNode.getRightChild());

        if(rightNodeBalance<-1){
            AWLTreeNode newRightNode=rotateLeft(currentNode.getRightChild());
            currentNode.setRightChild(newRightNode);
        }
        else if(rightNodeBalance>1){
            AWLTreeNode newRightNode=rotateRight(currentNode.getRightChild());
            currentNode.setRightChild(newRightNode);
        }
    }

    public static int calculateBalance(AWLTreeNode root) {
        if(root==null)
            return 0;
       int balance = depthTraversal(root.getLeftChild(),0)-depthTraversal(root.getRightChild(),0);
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

    public static AWLTreeNode rotateLeft(AWLTreeNode oldRoot){
        if (oldRoot == null || oldRoot.getRightChild() == null) {
            return oldRoot;
        }

        AWLTreeNode newRoot = oldRoot.getRightChild();
        AWLTreeNode subtree = newRoot.getLeftChild();

        newRoot.setLeftChild(oldRoot);
        oldRoot.setRightChild(subtree);

        return newRoot;
    }
    public static AWLTreeNode rotateRight(AWLTreeNode oldRoot){
        if (oldRoot == null || oldRoot.getLeftChild() == null) {
            return oldRoot;
        }

        AWLTreeNode newRoot = oldRoot.getLeftChild();
        AWLTreeNode subtree = newRoot.getRightChild();

        newRoot.setRightChild(oldRoot);
        oldRoot.setLeftChild(subtree);

        return newRoot;
    }
    private static AWLTreeNode rotateLeftRight(AWLTreeNode currentNode){
        AWLTreeNode newLeftNode=rotateLeft(currentNode.getLeftChild());
        currentNode.setLeftChild(newLeftNode);
        return rotateRight(currentNode);
    }
    private static AWLTreeNode rotateRightLeft(AWLTreeNode currentNode){
       AWLTreeNode newRightNode=rotateRight(currentNode.getRightChild());
       currentNode.setRightChild(newRightNode);
       return rotateLeft(currentNode);
    }
}
