package com.algorithm.string.com.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class SerializeTreeNode{
    public int value;
    public SerializeTreeNode left;
    public SerializeTreeNode right;

    public SerializeTreeNode(int value) {
        this.value = value;
    }
}

public class SerializeTree {
    //前序遍历树序列化
    public String serializeByPre(SerializeTreeNode treeNode){
        if(treeNode == null){
            return "#!";
        }
        String ans = treeNode.value + ",";
        ans += serializeByPre(treeNode.left);
        ans += serializeByPre(treeNode.right);
        return ans;
    }

    //前序遍历树的反序列化
    public SerializeTreeNode reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i != values.length; i++){
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public SerializeTreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        SerializeTreeNode header = new SerializeTreeNode(Integer.valueOf(value));
        header.left = reconPreOrder(queue);
        header.right = reconPreOrder(queue);
        return header;
    }

    //层序遍历的序列化
    public static String serializeByLayer(SerializeTreeNode treeNode){
        if(treeNode == null){
            return "#!";
        }
        Queue<SerializeTreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode);
        String ans = "";
        while(!queue.isEmpty()){
            SerializeTreeNode poll = queue.poll();

            if(poll.left != null){
                ans += poll.left.value + "!";
                queue.add(poll.left);
            }else{
                ans += "#!";
            }
            if(poll.right != null){
                ans += poll.right.value + "!";
                queue.add(poll.right);
            }else{
                ans += "#!";
            }
        }
        return ans;
    }

    //层序遍历的反序列化
    public static SerializeTreeNode reconLayerTree(String treeSerialize){
        String[] nodeValues = treeSerialize.split("!");
        int index = 0;
        SerializeTreeNode head = generateNodeByString(nodeValues[index++]);
        Queue<SerializeTreeNode> nodeValueQueue = new LinkedBlockingQueue<>();
        if(head != null){
            nodeValueQueue.offer(head);
        }
        SerializeTreeNode node = null;
        while(!nodeValueQueue.isEmpty()){
            node = nodeValueQueue.poll();
            node.left=generateNodeByString(nodeValues[index++]);
            node.right = generateNodeByString(nodeValues[index++]);
            if(node.left != null){
                nodeValueQueue.offer(node.left);
            }
            if(node.right!=null){
                nodeValueQueue.offer(node.right);
            }
        }
        return head;
    }

    public static SerializeTreeNode generateNodeByString(String val){
        if(val.equals("#")){
            return null;
        }
        return new SerializeTreeNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        SerializeTreeNode root = new SerializeTreeNode(1);
        root.left = new SerializeTreeNode(2);
        root.right = new SerializeTreeNode(3);
        SerializeTreeNode node = reconLayerTree(serializeByLayer(root));
    }
}
