package com.algorithm.queue;

public class LinkedQueue implements Queue {

    private int count;

    private QueueNode rear;

    private QueueNode front;

    public LinkedQueue() {
        this.count = 0;
        this.rear = this.front = new QueueNode(null);
    }

    @Override
    public void append(Object element) throws Exception {
        this.rear.setNext(new QueueNode(element,null));
        this.count ++;
    }

    @Override
    public Object delete() throws Exception {

        Object object = front.element;
        this.front.setNext(front.next.next);
        this.count --;
        return object;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Object getFront() throws Exception {
        if(this.count > 0){
            return this.front.getElement();
        }else{
            return null;
        }
    }
}
