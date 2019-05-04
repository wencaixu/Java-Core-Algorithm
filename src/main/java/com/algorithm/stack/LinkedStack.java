package com.algorithm.stack;


public class LinkedStack<T> {

    /**
     * 使用单例模式
     */
    private static class StackHandle{
        private static LinkedStack stack = new LinkedStack();
    }

    private static LinkedStack getInstance(){
        return StackHandle.stack;
    }

    /**
     * 链栈节点
     *
     * @param <T>
     */
    static class Node<T> {
        T date;
        Node<T> next;
    }

    /**
     * 栈底节点
     */
    private static Node first = null;

    /**
     * 栈的长度
     */
    private static int size = 0;

    /**
     * 初始化链
     */
    public void init() {
        first = new Node();
        first.date = null;
        first.next = null;
    }

    /**
     * 添加元素
     *
     * @param elem
     */
    public void push(Object elem) {
        Node newNode = new Node();
        newNode.date = elem;
        first.next = newNode;
        size++;
    }

    /**
     * 弹出顶部的数据
     *
     * @return
     */
    public Object pop() {
        Object date =  first.next.date;
        first.next = first.next.next;
        size--;
        return date;
    }

    /**
     * 获取顶部元素
     *
     * @return
     */
    public Object peck(){
        if(first ==  null){
            return null;
        }
        Object node = first.date;
        return first.next.date;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 链表长度
     *
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 遍历栈
     *
     */
    public void traverse(){
        Node header = first.next;
        while(header != null){
            System.out.print(header.date + " ");
            header = header.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedStack instance = LinkedStack.getInstance();
        instance.init();
        instance.push(2);
        System.out.println(instance.size());
        instance.traverse();
        System.out.println(instance.peck());
        System.out.println(instance.pop());
        instance.traverse();
        System.out.println(instance.isEmpty());

    }
}
