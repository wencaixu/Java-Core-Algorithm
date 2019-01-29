package com.algorithm.list;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class LinkList {

    private Node header = null;

    void insert(int index, int item) {
        Node n = new Node(item);
        if (header == null) {
            header = n;
        } else {
            int i = 0;
            while (i < index && header.next != null) {
                header = header.next;
            }
            n.next = header.next;
            header.next = n;
        }
    }

    void delete(int index) {
        if (index == 0) {
            header = header.next;
        } else {
            int i = 1;
            while (i < index && header.next != null) {
                header = header.next;
            }
        }
    }

    int length() {
        int i = 0;
        while (header.next != null) {
            header = header.next;
            i++;
        }
        return i;
    }

    int indexOf(int date) {
        int i = 0;
        while (header.next != null) {
            if (header.val == date) {
                return i;
            }
            header = header.next;
            i++;
        }
        return -1;
    }

    int get(int index) {
        int i = 0, item = 0;
        while (i < index && header.next != null) {
            item = header.val;
        }
        return item;
    }

    void tranverse() {
        while (header != null) {
            System.out.print(header.val + " ");
            header = header.next;
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insert(0, 12);
        list.insert(1, 13);
        list.insert(2, 14);
        list.tranverse();
        list.delete(2);
        list.tranverse();
    }
}
