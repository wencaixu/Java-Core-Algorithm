package com.algorithm.tree;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedTransferQueue;

class TreeBNode implements Comparable{
    int value;
    TreeBNode left;
    TreeBNode right;

    public TreeBNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
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
            if(tmpNode.right != null){
                nodes.push(tmpNode.left);
            }
            if(tmpNode.left!=null){
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

    //非递归方式的中序遍历
    public void inOrderTran(TreeBNode header){
        if(header == null){
            return ;
        }
        Stack<TreeBNode> stack = new Stack<>();
        while(!stack.isEmpty() || header != null){
            if(header.left != null){
                stack.push(header);
                header = header.left;
            }else{
                TreeBNode pop = stack.pop();
                System.out.println(pop.value);
                header = header.right;
            }
        }
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

    //非递归方式的后续遍历
    public void postOrderTran(TreeBNode header){
        if(header == null){
            return ;
        }
        Stack<TreeBNode> stack1 = new Stack<>();
        Stack<TreeBNode> stack2 = new Stack<>();
        stack1.push(header);
        while (!stack1.isEmpty()){
            header = stack1.pop();
            stack2.push(header);
            if(header.left != null){
                stack1.push(header.left);
            }
            if(header.right != null){
                stack1.push(header.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value + " ");
        }
        System.out.println();
    }

    //树的层序遍历递归方式
    Queue<TreeBNode> queue1 = new PriorityQueue<>();
    public void layerOrderRecur(TreeBNode header){
        if(header == null){
            return ;
        }
        queue1.add(header);
        while(!queue1.isEmpty()){
            TreeBNode pop = queue1.poll();
            System.out.println(pop.value + " ");
            if(pop.left != null){
                layerOrderRecur(pop.left);
            }
            if(pop.right != null){
                layerOrderRecur(pop.right);
            }
        }
    }

    //树的层序遍历非递归方式
    public void layerOrderTran(TreeBNode header){
        if(header == null){
            return;
        }
        Queue<TreeBNode> queue1 = new LinkedTransferQueue<>();
        Queue<TreeBNode> queue2 = new LinkedTransferQueue<>();
        queue1.add(header);
        while(!queue1.isEmpty()){
            TreeBNode node = queue1.poll();
            queue2.add(node);
            if(node.left != null){
                queue1.add(node.left);
            }
            if(node.right != null){
                queue1.add(node.right);
            }
        }
        while(!queue2.isEmpty()){
            TreeBNode node = queue2.poll();
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        TreeBNode root = new TreeBNode(10);
        root.left = new TreeBNode(11);
        root.right = new TreeBNode(12);
        root.left.left = new TreeBNode(13);
        root.left.right = new TreeBNode(14);

        new TransverseTree().layerOrderTran(root);
    }
}
