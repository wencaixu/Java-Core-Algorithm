package com.algorithm.string.com.algorithm.list;


class NthNode<T> {
    T date;
    NthNode<T> next;
    public NthNode() {
    }
    public NthNode(T date) {
        this.date = date;
    }
}

/**
 * 删除单链表中倒数第K个元素：一定要含有头指针
 *
 * @author Jerry Hsu
 */
public class RemoveNthNodeFromLast {

    public static NthNode removeNth(NthNode<Integer> nthNode, int N) {
        if (N < 0 || nthNode == null) {
            return null;
        }
        NthNode<Integer> cur = nthNode;
        while (cur != null) {
            N--;
            cur = cur.next;
        }
        //如果遍历一遍链表后，N=0,说明第一个元素为倒数第K个元素
        if (N == 0) {
            nthNode = nthNode.next;
        }
        //如果N < 0,从链表头部进行重新遍历
        if (N < 0) {
            cur = nthNode;
            while (++N != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return nthNode;
    }

    public static void main(String[] args) {
        NthNode<Integer> nth = new NthNode<>();
        nth.next = new NthNode<>(1);
        nth.next.next = new NthNode<>(2);
        nth.next.next.next = new NthNode<>(3);

        NthNode nthNode = removeNth(nth, 2);
        while(nthNode.next != null){
            nthNode = nthNode.next;
            System.out.println(nthNode.date);
        }
    }
}
