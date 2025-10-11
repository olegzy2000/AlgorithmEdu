package org.example.Math.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BTreeNode {
    private int treeDegree;
    private boolean isRoot=false;
    private BTreeNode parent=null;
    private TreeSet<Integer>currentKeys=new TreeSet<>();
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

    public TreeSet<Integer> getCurrentKeys() {
        return currentKeys;
    }

    public void setCurrentKeys(TreeSet<Integer> currentKeys) {
        this.currentKeys = currentKeys;
    }

    public List<BTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<BTreeNode> children) {
        this.children = children;
    }
    public int getMaxChildrenAmount(){
        return treeDegree;
    }
    public int getMinChildrenAmount(){
        return treeDegree;
    }
    public int getMinKeysAmount(){
        return treeDegree;
    }
    public int getMaxKeysAmount(){
        return treeDegree;
    }
}
