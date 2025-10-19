package org.example.Math.tree;

import org.example.Math.model.BTreeNode;
import java.util.List;

public class BTreeAlgorithm {
    public static BTreeNode start(int array[], int degrees){
        BTreeNode node=new BTreeNode();
        node.setTreeDegree(2);
        node.getCurrentKeys().add(array[0]);
        node.setRoot(true);
        for(int i=1;i<array.length;i++){
            node=addKey(node,array[i],false);
        }
        return node;
    }
    private static BTreeNode addKey(BTreeNode node, int newKey, boolean seperateAdding) {
        if(node==null){
            return node;
        }
        if(!node.getChildren().isEmpty()){
            int index=searchNodeByKeys(node.getCurrentKeys(),newKey);
            return addKey(node.getChildren().get(index),newKey,false);
        }
        else if(node.getChildren().isEmpty() || seperateAdding){
             if(2*node.getTreeDegree()-1>node.getCurrentKeys().size()){
                 node.getCurrentKeys().add(newKey);
             }
             else {
                 int indexOfNewRoot = node.getCurrentKeys().size()/2;

                 int newRootValue=node.getCurrentKeys().remove(indexOfNewRoot);
                 node.getCurrentKeys().add(newKey);

                 BTreeNode newRoot=node.getParent();
                 if(newRoot==null)
                     newRoot=new BTreeNode();
                 newRoot.setTreeDegree(node.getTreeDegree());
                 newRoot.setRoot(node.isRoot());
                 newRoot=addKey(newRoot,newRootValue,true);


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
         return node;
    }

    public static int searchNodeByKeys(List<Integer> currentKeys, int newKey) {
        if(currentKeys==null || currentKeys.isEmpty())
            return -1;
        for(int i=currentKeys.size()-1;i>=0;i--){
            if(newKey>=currentKeys.get(i)){
                return i+1;
            }
        }
        return 0;
    }
}
