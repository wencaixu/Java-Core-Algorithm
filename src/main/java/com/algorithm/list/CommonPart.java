package com.algorithm.list;


import java.util.ArrayList;
import java.util.List;

class ListNode<T>{
    T date;
    ListNode next;

    public ListNode(T date) {
        this.date = date;
    }
}

/**
 * 求出两个有序链表的公共部分
 * @author Jerry Hsu - 徐文才
 */
public class CommonPart {

    private static boolean isEmpty(ListNode list){
        boolean flag = false;
        if(list == null){
            flag = true;
        }
        return flag;
    }

    public static List<Integer> commonPart(ListNode<Integer> list01,ListNode<Integer> list02){
        List<Integer> list = new ArrayList<>();
        if(isEmpty(list01) || isEmpty(list02)){
            return null;
        }
        while(!isEmpty(list01) && !isEmpty(list02)){
            if(list01.date > list02.date){
                list02 = list02.next;
            }else if(list01.date < list02.date){
                list01 = list01.next;
            }else{
                list.add(list01.date);
                System.out.println(list01.date);
                list01 = list01.next;
                list02 = list02.next;

            }
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode<Integer> node01 = new ListNode<>(1);
        node01.next = new ListNode<>(2);
        node01.next.next = new ListNode<>(3);

        ListNode<Integer> node002 = new ListNode<>(2);
        node002.next = new ListNode<>(3);

        List<Integer> integers = commonPart(node01, node002);
        for(int i = 0; i < integers.size(); i++){
            System.out.println(integers.get(i));
        }
        Thread.currentThread().getName();
    }
}
