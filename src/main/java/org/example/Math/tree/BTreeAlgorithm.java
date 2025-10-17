package org.example.Math.tree;

import org.example.Math.model.BTreeNode;

import java.util.List;
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
        if(node==null){
            return node;
        }

        if(node.isRoot() && node.getChildren().isEmpty()){
             if(2*node.getTreeDegree()-1>node.getCurrentKeys().size()){
                 node.getCurrentKeys().add(newKey);
             }
             else {
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
                 newLeftNode.setParent(newRoot);
                 BTreeNode newRightNode=new BTreeNode();
                 newRightNode.setTreeDegree(node.getTreeDegree());
                 newRightNode.getCurrentKeys()
                         .addAll(node.getCurrentKeys()
                                 .stream()
                                 .filter(x->x>newRootValue)
                                 .toList());

                 newRightNode.setParent(newRoot);
                 newRoot.getChildren().add(newLeftNode);
                 newRoot.getChildren().add(newRightNode);
                 return newRoot;

             }
             return node;
         }
        else if(!node.getChildren().isEmpty()){
            int index=searchNodeByKeys(node.getCurrentKeys(),newKey);
            addKey(node.getChildren().get(index),newKey);
        }
        else if(node.getChildren().isEmpty()){

        }

         return node;
    }

    private static int searchNodeByKeys(List<Integer> currentKeys, int newKey) {
        for(int i=currentKeys.size()-1;i>=0;i--){
            if(newKey>=currentKeys.get(i)){
                return i;
            }
        }
        return 0;
    }
}
