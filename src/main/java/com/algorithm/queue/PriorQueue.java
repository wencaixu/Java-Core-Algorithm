package com.algorithm.queue;


/**
 * 优先队列
 */
public class PriorQueue implements Queue{

    private int rear;
    private int front;
    private int count;
    private int maxSize;
    private int defaultSize = 10;

    private Element[] elements = new Element[0];

    public PriorQueue(int size) {
        init(size);
    }

    public PriorQueue(){
        init(defaultSize);
    }

    private void init(int size){
        this.maxSize = size;
        this.count = 0;
        this.front = this.rear = 0;
        this.elements = new Element[size];
    }

    @Override
    public void append(Object element) throws Exception {
        if(this.count > maxSize){
            throw new Exception("队列已满");
        }
        int prior = Integer.parseInt(String.valueOf((int)(Math.random() * 10)));
        this.elements[rear] = new Element(element,prior);
        this.rear = (rear + 1) % maxSize;
        this.count++;
    }

    @Override
    public Object delete() throws Exception {
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        int min = this.elements[front].getPrior();
        int tmp = front;
        for(int i = 0; i < this.count; i++){
          if(this.elements[i].prior <= min){
              min = this.elements[i].prior;
              tmp = i;
          }
        }
        Element element = this.elements[tmp];
        for(int j = tmp + 1;j<this.count; j++){
            this.elements[j-1] = this.elements[j];
        }
        this.count --;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Object getFront() throws Exception {
        if(isEmpty()){
            return null;
        }
        int min = this.elements[front].prior;
        int tmp = front;
        for(int i = front + 1; i < this.rear; i++){
            if(this.elements[i].prior <= min){
                tmp = i;
                min = this.elements[i].prior;
            }
        }
        return this.elements[tmp].getPrior();
    }

    public static void main(String[] args) throws Exception {
        PriorQueue queue = new PriorQueue();
        queue.append(new Element(10));
        queue.append(new Element(11));
        queue.append(new Element(12));
        queue.append(new Element(13));
        queue.append(new Element(14));
        queue.append(new Element(15));

        queue.delete();

        queue.append(new Element(19));

        while(!queue.isEmpty()){
            Element element = (Element) queue.delete();
            System.out.println(element.toString());
        }
    }

    private static class Element{
        Object value;
        int prior;

        public Element(Object value) {
            this.value = value;
        }

        public Element(Object value, int prior) {
            this.value = value;
            this.prior = prior;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getPrior() {
            return prior;
        }

        public void setPrior(int prior) {
            this.prior = prior;
        }

        @Override
        public String toString() {
            return this.value+"->"+this.prior;
        }
    }
}
