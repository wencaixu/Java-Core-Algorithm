package com.algorithm.string.com.algorithm.stack;


public class ArrayStack {

    private static class Stack {
        static final ArrayStack stack = new ArrayStack();
    }

    public static ArrayStack getStack() {
        return Stack.stack;
    }

    private static int STACK_SIZE = 5;

    private static int stackSize = 0;

    private int top = 0;

    private int base = 0;

    private Object[] stacks = null;

    /**
     * 顺序栈初始化
     */
    public void init() {
        stacks = new Object[STACK_SIZE];
        top = 0;
        base = 0;
        stackSize = 0;
    }

    /**
     * 栈顶添加元素
     *
     * @param elem
     */
    public void push(int elem) {
        if (top - base >= STACK_SIZE) {
            System.out.println("空间已满");
        }
        stacks[top++] = elem;
        stackSize++;
    }

    /**
     * 栈中取出元素
     *
     * @return
     */
    public Object pop() {
        Object o = null;
        if (top == base) {
            System.out.println("栈为空");
        }
        o = stacks[--top];
        stackSize--;
        return o;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public Object peck() {
        Object o = null;
        if (top == base) {
            System.out.println("栈为空");
        }
        o = stacks[top - 1];
        return o;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == base && stackSize == 0;
    }

    /**
     * 栈的长度
     *
     * @return
     */
    public int size() {
        return stackSize;
    }

    /**
     * 栈遍历
     *
     */
    public void traverse(){
        for(int i = 0; i < stackSize; i++){
            System.out.print(stacks[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = ArrayStack.getStack();
        stack.init();
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.pop();
        stack.traverse();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
