package org.example.Math.tree;

import org.example.Math.model.BTreeNode;
import java.util.List;

public class BTreeAlgorithm {
    public static BTreeNode start(int array[], int degrees){
        BTreeNode node=new BTreeNode();
        node.setTreeDegree(2);
        node.addNewKey(array[0]);
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
        if(!node.getChildren().isEmpty() && !seperateAdding){
            int index=searchNodeByKeys(node.getCurrentKeys(),newKey);
            addKey(node.getChildren().get(index),newKey,false);
        }
        else if(node.getChildren().isEmpty() || seperateAdding){
             if(2*node.getTreeDegree()-1>node.getCurrentKeys().size()){
                 node.addNewKey(newKey);
             }
             else {
                 int indexOfNewRoot = node.getCurrentKeys().size()/2;

                 int newRootValue = node.removeKeyByIndex(indexOfNewRoot);




                 node.addNewKey(newKey);
                 BTreeNode newRoot=node.getParent();
                 if(newRoot==null) {
                     newRoot = new BTreeNode();
                     newRoot.setRoot(true);
                     newRoot.setTreeDegree(node.getTreeDegree());
                 }

                 // newRoot=addKey(newRoot,newRootValue,true);


                 final BTreeNode newLeftNode=new BTreeNode();
                 newLeftNode.setTreeDegree(node.getTreeDegree());


                 newLeftNode.addListKey(node.getCurrentKeys()
                         .stream()
                         .filter(x->x<=newRootValue)
                         .toList());
                 newLeftNode.setParent(newRoot);



                 final BTreeNode newRightNode=new BTreeNode();
                 newRightNode.setTreeDegree(node.getTreeDegree());
                 newRightNode.addListKey(node.getCurrentKeys()
                                 .stream()
                                 .filter(x->x>newRootValue)
                                 .toList());
                 newRightNode.setParent(newRoot);



                 List<BTreeNode>leftPart=node.getChildren().stream().filter(x->{
                     return x.getCurrentKeys().stream().anyMatch(y->y<newKey);
                 }).toList();

                 leftPart.forEach(x->{
                     x.setParent(newLeftNode);
                 });

                 newLeftNode.getChildren().addAll(leftPart);


                 List<BTreeNode>rightPart=node.getChildren().stream().filter(x->{
                     return x.getCurrentKeys().stream().anyMatch(y->y>=newKey);
                 }).toList();

                 rightPart.forEach(x->{
                     x.setParent(newRightNode);
                 });

                 newRightNode.getChildren().addAll(rightPart);




                 if(newRoot.getMaxChildrenAmount()>=newRoot.getChildren().size()+2) {
                     newRoot.getChildren().add(newLeftNode);
                     newRoot.getChildren().add(newRightNode);
                 }
                 newRoot.getChildren().remove(node);
                 newRoot=addKey(newRoot,newRootValue,true);

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
