package org.example.Math.model;

public class AWLTreeNode {
    private int value;
    private AWLTreeNode leftChild;
    private AWLTreeNode rightChild;
    private AWLTreeNode parent;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AWLTreeNode getParent() {
        return parent;
    }

    public void setParent(AWLTreeNode parent) {
        this.parent = parent;
    }

    public AWLTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AWLTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public AWLTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AWLTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "AWLTreeNode{" +
                "value=" + value +
                ", parent=" + parent +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
