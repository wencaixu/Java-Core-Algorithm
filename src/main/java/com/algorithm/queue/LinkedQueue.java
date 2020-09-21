package com.algorithm.queue;

public class LinkedQueue implements Queue {

    private int count;

    private QueueNode rear;

    private QueueNode front;

    public LinkedQueue() {
        this.count = 0;
        this.rear = this.front = null;
    }

    @Override
    public void append(Object element) throws Exception{
        QueueNode node = new QueueNode(element,null);
        if(rear != null){
            rear.next = node;
        }
        rear = node;
        if(front == null){
            front = node;
        }
        count ++;
    }

    @Override
    public Object delete() throws Exception {
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        Object object = front.element;
        this.front = front.next;
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

    public static void main(String[] args) throws Exception {
        LinkedQueue queue = new LinkedQueue();
        queue.append("aa");
        queue.append("bb");
        queue.append("cc");
        queue.append("dd");
        queue.append("ee");

        queue.delete();

        queue.append("ff");

        while(!queue.isEmpty()){
            System.out.println(queue.delete());
        }
    }
}
