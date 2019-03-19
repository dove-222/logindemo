package com.smart.entity;


import java.util.Objects;

public class TreeNode<T>  {

    T value;

    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T value){
        this.value = value;
    }

    public TreeNode(){

    }

    /**
     * 增加左子树
     */
    public void addLeft(T value){
        TreeNode<T> leftChild = new TreeNode<T>(value);
        this.leftChild = leftChild;
    }

    /**
     * 增加右子树
     */
    public void addRight(T value){
        TreeNode<T> rightChild = new TreeNode<T>(value);
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(value, treeNode.value) &&
                Objects.equals(leftChild, treeNode.leftChild) &&
                Objects.equals(rightChild, treeNode.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftChild, rightChild);
    }

    @Override
    public String toString() {
        return this.value==null?"null":this.value.toString();
    }
}
