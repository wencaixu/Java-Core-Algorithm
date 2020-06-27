package com.algorithm.queue;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用两个栈实现队列的peek,add poll
 *
 * @param <R>
 */
public class StackQueue<R> {

    private Stack<R> input = new Stack<>();
    private Stack<R> output= new Stack<>();

    public void add(R element){
        input.add(element);
    }


    public R poll(){
       if(output.isEmpty()){
            while(!input.isEmpty()){
                R r = input.pop();
                output.add(r);
            }
            return output.pop();
        }
        return output.pop();
    }

    public R peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                R r = input.pop();
                output.add(r);
            }
            return output.peek();
        }
        return output.peek();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(1);
        stackQueue.add(2);
        System.out.println(stackQueue.poll());
        stackQueue.add(3);

        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());

        Queue queue = new ArrayDeque();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.element());
    }


}
