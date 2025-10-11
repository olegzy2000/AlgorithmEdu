package org.example.Math.tree;

import org.example.Math.model.BTreeNode;

public class BTreeAlgorithm {
    public BTreeNode start(int array[]){
        BTreeNode node=new BTreeNode();
        node.setParent(null);
        node.setTreeDegree(2);
        node.getCurrentKeys().add(array[0]);
        node.setRoot(true);
        for(int i=1;i<array.length;i++){
            node=addKey(node,array[i]);
        }
        return node;
    }
    private BTreeNode addKey(BTreeNode node, int newKey) {
         if(node.isRoot() && node.getChildren().isEmpty()){
             node.getCurrentKeys().add(newKey);
             return node;
         }
         else if(node.isRoot() || !node.getChildren().isEmpty()){
             return node;
         }
         return node;
    }
}
