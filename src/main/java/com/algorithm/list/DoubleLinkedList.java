package com.algorithm.list;


class DoubleNode<T> {
    T date;
    DoubleNode previous;
    DoubleNode next;
}

public class DoubleLinkedList {

    private static DoubleNode header;

    private static int length = 0;

    private DoubleNode init() {
        header = new DoubleNode();
        header.date = 0;
        header.previous = null;
        header.next = null;
        return header;
    }

    private int size(DoubleNode node) {
       return length;
    }

    private void insert(int index, int date) {
        int i = 0;
        DoubleNode preNode = header;
        while (preNode != null && i < index - 1) {
           ++i;
           preNode = preNode.next;
        }
        if(preNode == null || i != index - 1) return;
        DoubleNode newNode = new DoubleNode();
        newNode.date = date;
        if(preNode.next == null){
            preNode.next = newNode;
            preNode.previous = preNode;
            newNode.next = null;
            ++length;
        }
        DoubleNode nextNode = preNode.next;
        newNode.next = nextNode;
        newNode.previous = preNode;
        preNode.next = newNode;
        nextNode.previous = newNode;
        ++length;
    }

    public void delete(int index) {
        if(index < 0 || index >= length) return;
        int i = 0;
        DoubleNode curNode = header;
        while(curNode != null && i != index){
            ++ i;
            curNode = curNode.next;
        }
        if(i != index || curNode == null) return;
        if(curNode.next == null){
            curNode.previous.next = null;
            curNode = null;
        }
        if(curNode.next!= null){
            curNode.previous.next = curNode.next;
            curNode.next.previous = curNode.previous;
        }
        --length;
    }

    public static void main(String[] args) {
       DoubleLinkedList linkedList = new DoubleLinkedList();
       linkedList.init();
       linkedList.insert(1,2);
       //linkedList.tranverse();
    }
}
