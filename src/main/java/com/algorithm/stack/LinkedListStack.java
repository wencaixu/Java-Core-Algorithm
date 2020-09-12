package com.algorithm.stack;

/**
 * 链栈
 *
 * @author wencai.xu
 */
public class LinkedListStack implements StackInterface{

    /**
     * 链表长度
     */
    private int size;

    /**
     * 头节点
     */
    private LinkedStackNode head;

    public LinkedListStack() {
        head = new LinkedStackNode(null);
    }

    /**
     * 栈顶元素
     */
    @Override
    public Object getTop() throws Exception {
        if(!isNotEmpty()){
            throw new Exception("当前栈为空");
        }
        return head.next.getElement();
    }

    /**
     * 添加元素
     */
    @Override
    public void push(Object element) {
        head.setNext(new LinkedStackNode(element,head.next));
        this.size ++;
    }

    /**
     * 弹出元素
     */
    @Override
    public Object pop() {
        this.size --;
        Object element = head.next.getElement();
        head.setNext(head.next.next);
        return element;
    }

    /**
     * 是否为空
     */
    @Override
    public boolean isNotEmpty() {
        return this.head != null;
    }

    /**
     * 当前长度
     */
    @Override
    public int currentSize() {
        return this.size;
    }

    public static void main(String[] args) throws Exception {
        LinkedListStack stack = new LinkedListStack();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        System.out.println("当前栈是否为空"+stack.isNotEmpty());
        System.out.println("当前栈长度"+stack.currentSize());
        System.out.println("获取栈顶元素"+stack.getTop());
        stack.push(111);
        System.out.println("栈顶元素"+stack.getTop());
        int currentSize = stack.currentSize();
        for(int i = 0; i < currentSize; i++){
            System.out.println(stack.pop());
        }
    }
}
