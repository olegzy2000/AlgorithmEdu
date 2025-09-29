package org.example.Math.model;

import java.util.Objects;

public class AWLTreeNode implements Cloneable{
    private int value;
    private AWLTreeNode leftChild;
    private AWLTreeNode rightChild;

    public AWLTreeNode(int value, AWLTreeNode leftChild, AWLTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;

    }
    @Override
    public AWLTreeNode clone(){
        AWLTreeNode awlTreeNode = null;
        try {
            awlTreeNode = (AWLTreeNode) super.clone();
            awlTreeNode.leftChild = this.getLeftChild().clone();
            awlTreeNode.rightChild = this.getRightChild().clone();
            awlTreeNode.value = this.value;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return awlTreeNode;
    }

    public AWLTreeNode(){

    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AWLTreeNode that = (AWLTreeNode) o;
        return value == that.value && Objects.equals(leftChild, that.leftChild) && Objects.equals(rightChild, that.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftChild, rightChild);
    }
}
