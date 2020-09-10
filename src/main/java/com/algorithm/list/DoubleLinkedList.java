package com.algorithm.list;

public class DoubleLinkedList implements List{

    /**
     * 链表长度
     */
    private int size;

    /**
     * 头指针
     */
    private DoubleListNode head;

    /**
     * 当前指针
     */
    private DoubleListNode current;


    public DoubleLinkedList() {
        this.head = current = new DoubleListNode(null);
        // 初始长度为0
        this.size = 0;
        // 头节点的前趋和后继都指向头节点
        this.head.next = head;
        this.head.prior = head;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 定位函数
     */

    private void index(int index) throws Exception {
        if(index < -1 || index > size - 1){
            throw new Exception("参数失败");
        }
        // 头节点
        if(index == -1){
            return;
        }
        int j = 0;
        current = head.next;
        while(current != head && j < index){
            current = current.next;
            j++;
        }
    }

    @Override
    public void insert(int index, Object value) throws Exception {
        if(index < 0 || index > size){
            throw new Exception("参数错误");
        }
        index(index - 1);
        current.setNext(new DoubleListNode(value,current.next));
        current.next.setPrior(current);
        current.next.next.setPrior(current.next);
        size ++;
    }

    @Override
    public void delete(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空，无法删除");
        }
        if(index < 0 || index > size){
            throw new Exception("参数错误");
        }
        index(index - 1);
        current.setNext(current.next.next);
        current.next.setPrior(current);
        size --;
    }

    @Override
    public Object get(int index) throws Exception {
        if(index < 0 || index > size - 1){
            throw new Exception("参数失败");
        }
        index(index);
        return current.element;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DoubleLinkedList list = new DoubleLinkedList();
        for(int i=0;i<10;i++)
        {
            int temp = ((int)(Math.random()*100))%100;
            list.insert(i, temp);
            System.out.print(temp+" ");
        }
        list.delete(4);
        System.out.println("\n------删除第五个元素之后-------");
        for(int i=0;i<list.size;i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
