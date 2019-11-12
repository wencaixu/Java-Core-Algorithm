package com.algorithm.tree;

/**
 * 获取树的高度
 * @author Jerry Xu
 */
public class TreeHeight {

    public static int treeHeight(TreeBNode treeBNode){
        if(treeBNode == null){
            return 0;
        }
        int leftChildTreeHeight = treeHeight(treeBNode.left);
        int rightChildTreeHeight = treeHeight(treeBNode.right);
        return Math.max(leftChildTreeHeight,rightChildTreeHeight) + 1;
    }

    public static void main(String[] args) {
        TreeBNode root = new TreeBNode(10);
        root.left = new TreeBNode(11);
        root.right = new TreeBNode(12);
        root.left.left = new TreeBNode(13);
        root.left.right = new TreeBNode(14);

        System.out.println(treeHeight(root));
    }
}
