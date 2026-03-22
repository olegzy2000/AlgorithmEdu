package org.example.Math.model;

import java.util.*;

public class BTreeNode {
    private int treeDegree;
    private boolean isRoot=false;
    private BTreeNode parent=null;
    private List<Integer>currentKeys=new ArrayList<>();
    private List<BTreeNode> children=new ArrayList<>();

    public int getTreeDegree() {
        return treeDegree;
    }

    public void setTreeDegree(int treeDegree) {
        this.treeDegree = treeDegree;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public BTreeNode getParent() {
        return parent;
    }

    public void setParent(BTreeNode parent) {
        this.parent = parent;
    }

    public List<Integer> getCurrentKeys() {
        return Collections.unmodifiableList(currentKeys);
    }
    public void addNewKey(Integer key) {
        currentKeys.add(key);
        Collections.sort(currentKeys);
    }
    public void addListKey(List<Integer> keys) {
        currentKeys.addAll(keys);
        Collections.sort(currentKeys);
    }
    public int removeKeyByIndex(int index) {
        return currentKeys.remove(index);
    }
    public void removeKeyByValue(Integer value) {
        currentKeys.remove(value);
    }


    public void setCurrentKeys(List<Integer> currentKeys) {
        this.currentKeys = currentKeys;
    }

    public List<BTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<BTreeNode> children) {
        this.children = children;
    }
    //for root 2t-1
    //for node 2t-1
    public int getMaxChildrenAmount(){
        if(!isRoot)
        return 2*treeDegree-1;
        else
            return 2*treeDegree;
    }
    //for root 1
    //for node t-1
    public int getMinChildrenAmount(){
        return treeDegree;
    }
    public int getMinKeysAmount(){
        return treeDegree;
    }
    public int getMaxKeysAmount(){
        return treeDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BTreeNode bTreeNode = (BTreeNode) o;
        return treeDegree == bTreeNode.treeDegree && isRoot == bTreeNode.isRoot && Objects.equals(currentKeys, bTreeNode.currentKeys) && Objects.equals(children, bTreeNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeDegree, isRoot, currentKeys, children);
    }

    @Override
    public String toString() {
        return "BTreeNode{" +
                "treeDegree=" + treeDegree +
                ", isRoot=" + isRoot +
               // ", parent=" + parent +
                ", currentKeys=" + currentKeys +
                ", children=" + children +
                '}';
    }
}
