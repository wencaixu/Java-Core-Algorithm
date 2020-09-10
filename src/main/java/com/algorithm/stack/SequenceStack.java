package com.algorithm.stack;


public class SequenceStack implements StackInterface {

    private Object[] elements;

    private int top;

    private int currentSize;

    private int defaultSize = 10;


    public SequenceStack(int size) {
        this.defaultSize = size;
        init(size);
    }

    public SequenceStack() {
        init(defaultSize);
    }

    private void init(int size){
        this.elements = new Object[size];
        // 初始top指针
        this.top = 0;
        this.currentSize = 0;
    }

    @Override
    public Object getTop() throws Exception {
        if(!isNotEmpty()){
            throw new Exception("当前栈为空");
        }
        return elements[this.top - 1];
    }

    @Override
    public void push(Object element) throws Exception {
        if(this.top > this.defaultSize){
            throw new Exception("超过最大栈元素个数");
        }
        this.elements[top++] = element;
        this.currentSize ++;
    }

    @Override
    public Object pop() throws Exception {
        if(!this.isNotEmpty()){
            throw new Exception("当前栈为空");
        }
        this.currentSize --;
        return this.elements[--top];
    }

    @Override
    public boolean isNotEmpty() {
        return this.top != 0;
    }

    @Override
    public int currentSize() {
        return this.currentSize;
    }

    public static void main(String[] args) throws Exception {
        SequenceStack stack = new SequenceStack();
        for(int i = 0; i < 5; i++){
            stack.push(i);
        }
        System.out.println("current size:"+stack.currentSize());
        for(int i = 0; i < 5; i++){
            System.out.println(stack.pop());
        }
        System.out.println("current size:"+stack.currentSize());
    }
}
