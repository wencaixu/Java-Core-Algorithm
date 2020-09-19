package com.algorithm.queue;


/**
 * 双向队列
 *
 * @author wencai.xu
 */
public class CircleSequenceQueue implements Queue{

    /**
     * 顺序队列
     */
    private Object[] queue;

    /**
     * 最大长度
     */
    private int maxSize = 0;

    /**
     * 队尾
     */
    private int rear;

    /**
     * 对头
     */
    private int front;

    /**
     * 长度
     */
    private int count = 0;

    private void init(int size){
        this.maxSize = size;
        this.count = 0;
        this.rear = this.front = 0;
        queue = new Object[size];
    }

    public CircleSequenceQueue() {
        int defaultSize = 10;
        init(defaultSize);
    }

    public CircleSequenceQueue(int size) {
        init(size);
    }

    @Override
    public void append(Object element) throws Exception {
        if(this.count > 0 && this.rear == this.front){
            throw new Exception("顺序队列已满");
        }
        this.queue[rear] = element;
        this.rear = (this.rear + 1) % this.maxSize;
        this.count ++;
    }


    @Override
    public Object delete() throws Exception {
        if(isEmpty()){
            throw new Exception("顺序队列为空");
        }
        Object front = this.queue[this.front];
        this.front = (this.front + 1) % maxSize;
        this.count --;
        return front;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0 && this.rear == this.front;
    }

    @Override
    public Object getFront() throws Exception {
        return this.queue[front];
    }

    public static void main(String[] args) throws Exception {
        CircleSequenceQueue circleSequenceQueue = new CircleSequenceQueue();
        circleSequenceQueue.append("a");
        circleSequenceQueue.append("b");
        circleSequenceQueue.append("c");
        circleSequenceQueue.append("d");
        circleSequenceQueue.append("e");
        circleSequenceQueue.append("f");
        circleSequenceQueue.append("g");

        circleSequenceQueue.delete();
        circleSequenceQueue.delete();

        circleSequenceQueue.append("h");

        while(!circleSequenceQueue.isEmpty()){
            System.out.println(circleSequenceQueue.delete());
        }
    }
}
