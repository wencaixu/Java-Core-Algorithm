package com.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/11,0011
 * @Version V1.0
 **/
public class Solution2 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int temp = 0;
      List<Integer> values = new ArrayList<>();
      while(l1 != null && l2 != null){
          int valL1 = l1.val;
          int valL2 = l2.val;

          values.add((valL1+valL2+temp) % 10);
          temp = (valL1 + valL2 + temp) / 10;

          l1 = l1.next;
          l2 = l2.next;
      }

      while(l1 != null){
          int valL1 = l1.val;
          values.add((valL1 + temp) % 10);
          temp = (valL1 + temp) / 10;
          l1 = l1.next;
      }

      while(l2 != null){
          int valL2 = l2.val;
          values.add((valL2 + temp) % 10);
          temp = (valL2 + temp) / 10;
          l2 = l2.next;
      }

      ListNode node = null;
      if(values.size() == 0){
          return null;
      }
      if(values.size() == 1){
         node = new ListNode(values.get(values.size()-1));
         if(temp != 0){
             node.next = new ListNode(temp);
         }
         return node;
      }
      // 尾插法
      node = new ListNode(values.get(0));
      ListNode r = node; // 尾指针r指向头节点
      for(int i = 1; i <= values.size() - 1; i++){
         ListNode newNode = new ListNode(values.get(i)); // 新节点
         newNode.next = null;
         r.next = newNode; // r接纳新节点
         r = newNode;  // r指向尾节点
      }
      if(temp != 0){
          ListNode newNode = new ListNode(temp);
          newNode.next = null;
          r.next = newNode;
          r = newNode;
      }
      // 头插法

      // node = new ListNode(values.get(temp));

      //for(int i = 0; i < values.size() - 1; i++){
      //    ListNode newNode = new ListNode(values.get(values.size()-i-1));
      //    newNode.next = node; // 新节点指向头指针
      //    node = newNode; // 头节点指向新节点
      //}
      return node;
  }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = l3;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int x, y;
            if(temp1 == null){
                x = 0;
            }
            else{
                x = temp1.val;
            }
            if(temp2 == null){
                y = 0;
            }
            else{
                y = temp2.val;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            temp3.next = new ListNode(sum % 10);
            temp3 = temp3.next;
            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;
            }

        }
        if(carry > 0){
            temp3.next = new ListNode(carry);
        }
        return l3.next;
    }


    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
  public static void main(String[] args) {
      //[2,4,3], l2 = [5,6,4]
      ListNode l1 = new ListNode(5);
      //l1.next = new ListNode(4);
      //l1.next.next = new ListNode(3);

      ListNode l2 = new ListNode(5);
      //l2.next = new ListNode(6);
      //l2.next.next = new ListNode(4);

      ListNode listNode = addTwoNumbers(l1, l2);
      while(listNode != null){
          System.out.println(listNode.val);
          listNode = listNode.next;
      }

  }

  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
