package com.algorithm.list;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 单链表反转
 * @author wencai.xu
 */
public class ListRevert {

    @Data
    @AllArgsConstructor
    static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static Node reverseList(Node header){
        Node pre = null;
        Node next = null;
        while(header != null){
            next = header.next;
            header.next = pre;
            pre = header;
            header = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node header = new Node(0);
        for(int i = 1; i < 10; i++){
            Node newNode = new Node(i);
            newNode.next = header.next;
            header.next = newNode;
        }
        Node node = reverseList(header);
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}
