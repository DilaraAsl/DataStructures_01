package cydeo.com.treeLeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode rootNode=new TreeNode(10);

        BinarySearchTree tree=new BinarySearchTree();
        tree.root=rootNode;
        tree.insert(6);
        tree.insert(20);
        tree.insert(4);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(3);
        tree.insert(9);
        tree.insert(29);
        tree.insert(47);

       System.out.println(findMaxNodeDepth(rootNode));


    }
    public static int findMaxNodeDepth(TreeNode root){
        if(root==null) return 0;
        int depthL=findMaxNodeDepth(root.left);

        int depthR=findMaxNodeDepth(root.right);

        // if root has no children Math.max(0,0)+1
        return Math.max(depthL,depthR)+1;
    }

    public static int findLevelOfNode(TreeNode root,int key,int level){
        if(root==null) return -1; // pops out of stack
        if(root.val==key) return level; //
        int l= findLevelOfNode(root.left,key,level+1);
        if(l!=-1) return l;
        return findLevelOfNode(root.right,key,level+1);
    }
    public static int findValueNode(TreeNode root){
        if(root==null) return 0;
    int valueL=findValueNode(root.left);
        System.out.println(valueL);
   int valueR=findValueNode(root.right);
        System.out.println(valueR);

        return root.val+valueL+valueR;
    }
}
