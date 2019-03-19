package com.smart.entity;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTools {

    /**
     * 判断树中节点个数
     */
    public static <T> int getTreeNum(TreeNode<T> root){
        if (root == null){
            return 0;
        }
        return getTreeNum(root.leftChild) + getTreeNum(root.rightChild) +1;
    }

    public static <T> int getTreeDept(TreeNode<T> root){
        if (root == null){
            return 0;
        }
        int leftDepth = getTreeDept(root.leftChild) +1;
        int rightDepth = getTreeDept(root.rightChild)+1;
        return Math.max(leftDepth,rightDepth);
    }
    /**
     * visitNode:访问node节点
     */
    private static <T> void visitNode(TreeNode<T> node){
        System.out.println(node.value+"\t");
    }
    /**
     * perOrderTravel:前序遍历
     */
    public static <T> void perOrderTravel (TreeNode<T> root){
        if(root == null){
            return;
        }
        visitNode(root);
        perOrderTravel(root.leftChild);
        perOrderTravel(root.rightChild);
    }
    /**
     * midOrderTravel:中序遍历
     */
    public static <T> void mideOrderTravel(TreeNode<T> root){
        if(root == null){
            return;
        }
        mideOrderTravel(root.leftChild);
        visitNode(root);
        mideOrderTravel(root.rightChild);
    }
    /**
     * backOrderTravel：后序遍历
     */
    public static <T> void backOrderTravel(TreeNode<T> root){
        if (root == null){
            return;
        }
        backOrderTravel(root.leftChild);
        backOrderTravel(root.rightChild);
        visitNode(root);
    }
    public static <T> void levelTravel(TreeNode<T> root){
        Queue<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode<T> temp = q.poll();
            visitNode(temp);
            if(temp.leftChild != null){
                q.offer(temp.leftChild);
            }
            if(temp.rightChild != null){
                q.offer(temp.rightChild);
            }
        }
    }
}
