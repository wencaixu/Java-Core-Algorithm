package com.algorithm.tree;


import java.util.Stack;

class TreeBNode{
    int value;
    TreeBNode left;
    TreeBNode right;

    public TreeBNode(int value) {
        this.value = value;
    }
}

/**
 * 树的前序遍历、中序遍历、后序遍历、层序遍历
 * @author Jerry Hsu
 */
public class TransverseTree {

    //递归方式的前序遍历
    public void preOrderRecur(TreeBNode header){
        if(header == null){
            return ;
        }
        System.out.println(header.value);
        preOrderRecur(header.left);
        preOrderRecur(header.right);
    }

    //非递归方式的前序遍历
    public void preOrderTran(TreeBNode header){
        if(header == null){
            return ;
        }
        Stack<TreeBNode> nodes = new Stack<>();
        nodes.push(header);
        while(!nodes.isEmpty()){
            TreeBNode tmpNode = nodes.pop();
            System.out.println(tmpNode.value);
            if(tmpNode.left != null){
                nodes.push(tmpNode.left);
            }
            if(tmpNode.right!=null){
                nodes.push(tmpNode.right);
            }
        }
    }

    //递归方式的中序遍历
    public void inOrderRecur(TreeBNode header){
        if(header == null){
            return ;
        }
        inOrderRecur(header.left);
        System.out.println(header.value);
        inOrderRecur(header.right);
    }

    //递归方式的后续遍历
    public void postOrderRecur(TreeBNode header){
        if(header == null){
            return ;
        }
        postOrderRecur(header.left);
        postOrderRecur(header.right);
        System.out.println(header.value);
    }

    //树的层序遍历
    public void layerOrder(TreeBNode header){
        if(header == null){
            return ;
        }

    }

    public static void main(String[] args) {
       //Test
    }
}
