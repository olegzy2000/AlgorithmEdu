package org.example.Math.tree;

import org.example.Math.model.BTreeNode;

import java.util.stream.Collectors;

public class BTreeAlgorithm {
    public static BTreeNode start(int array[], int degrees){
        BTreeNode node=new BTreeNode();
        node.setTreeDegree(2);
        node.getCurrentKeys().add(array[0]);
        node.setRoot(true);
        for(int i=1;i<array.length;i++){
            node=addKey(node,array[i]);
        }
        return node;
    }
    private static BTreeNode addKey(BTreeNode node, int newKey) {
         if(node.isRoot() && node.getChildren().isEmpty()){
             if(2*node.getTreeDegree()-1>node.getCurrentKeys().size()){
                 node.getCurrentKeys().add(newKey);
             }
             else {
                 //first time where tree deep set 2
                 int indexOfNewRoot = node.getCurrentKeys().size()/2;

                 int newRootValue=node.getCurrentKeys().remove(indexOfNewRoot);
                 node.getCurrentKeys().add(newKey);

                 BTreeNode newRoot=new BTreeNode();
                 newRoot.setTreeDegree(node.getTreeDegree());
                 newRoot.setRoot(true);
                 newRoot=addKey(newRoot,newRootValue);


                 BTreeNode newLeftNode=new BTreeNode();
                 newLeftNode.setTreeDegree(node.getTreeDegree());
                 newLeftNode.getCurrentKeys()
                         .addAll(node.getCurrentKeys()
                                 .stream()
                                 .filter(x->x<=newRootValue)
                                 .toList());

                 BTreeNode newRightNode=new BTreeNode();
                 newRightNode.setTreeDegree(node.getTreeDegree());
                 newRightNode.getCurrentKeys()
                         .addAll(node.getCurrentKeys()
                                 .stream()
                                 .filter(x->x>newRootValue)
                                 .toList());

                 newRoot.getChildren().add(newLeftNode);
                 newRoot.getChildren().add(newRightNode);
                 return newRoot;

             }
             return node;
         }
         else if(node.isRoot() || !node.getChildren().isEmpty()){

         }

         return node;
    }
}
