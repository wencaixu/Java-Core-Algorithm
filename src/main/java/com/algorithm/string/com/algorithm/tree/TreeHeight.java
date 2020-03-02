package com.algorithm.string.com.algorithm.tree;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class TreeNode2 implements Comparable{
    int value;
    TreeNode2 left;
    TreeNode2 right;
    int layer;

    public TreeNode2(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

/**
 * 获取树的高度
 * @author Jerry Xu
 */
public class TreeHeight {

    /**
     * 使用递归
     * @param treeBNode
     * @return
     */
    public static int treeHeight(TreeNode2 treeBNode){
        if(treeBNode == null){
            return 0;
        }
        int leftChildTreeHeight = treeHeight(treeBNode.left);
        int rightChildTreeHeight = treeHeight(treeBNode.right);
        return Math.max(leftChildTreeHeight,rightChildTreeHeight) + 1;
    }

    /**
     * 使用层序遍历实现
     * @param treeBNode
     * @return
     */
    public static int treeHeight2(TreeNode2 treeBNode){
        if(treeBNode == null){
            return 0;
        }
        Queue<TreeNode2> queue = new LinkedBlockingDeque<>();
        Queue<TreeNode2> queue1 = new LinkedBlockingDeque<>();
        treeBNode.layer = 1;
        queue.add(treeBNode);
        while(!queue.isEmpty()){
            TreeNode2 node2 = queue.poll();
            queue1.add(node2);
            if(node2.left != null){
                node2.left.layer = node2.layer + 1;
                queue.add(node2.left);
            }
            if(node2.right != null){
                node2.right.layer = node2.layer + 1;
                queue.add(node2.right);
            }
        }
        int i = 0;
        while(!queue1.isEmpty()){
            i = queue1.poll().layer;
        }
        return i;
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(10);
        root.left = new TreeNode2(11);
        root.right = new TreeNode2(12);
        root.left.left = new TreeNode2(13);
        root.left.right = new TreeNode2(14);

        System.out.println(treeHeight2(root));
    }
}
