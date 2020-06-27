package com.algorithm.stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackMins<T extends Comparable> {

    private Stack<T> stackData;
    private Stack<T> stackMin ;

    public StackMins() {
        this.stackData = new Stack<>();
        this.stackMin  = new Stack<>();
    }

    public void put(T element){
        stackData.push(element);
        if(stackMin.isEmpty()){
            stackMin.push(element);
        }else{
            T peek = stackMin.peek();
            //此种添加情况min栈数量小于data栈数量
            if(peek.compareTo(element) >= 0){
                stackMin.push(element);
            }
        }
    }

    public T pop(){
        if(stackData.isEmpty()){
            //stackData 为空，则stackMin一定为空
            return null;
        }else{
            T pop = stackData.pop();
            T peek = stackMin.peek();
            if(pop.compareTo(peek) == 0){
                stackMin.pop();
            }
            return pop;
        }
    }

    public T getMin(){
        if(stackMin.isEmpty()){
            return null;
        }
        return stackMin.peek();
    }

    public T peek(){
        if(stackData.isEmpty()){
            return null;
        }
        return stackData.peek();
    }

    public static void main(String[] args) {
        StackMins<Integer> stackMins = new StackMins<>();
        stackMins.put(1);
        stackMins.put(2);
        stackMins.put(-1);
        stackMins.put(0);

        System.out.println(stackMins.pop());
        System.out.println(stackMins.getMin());
        System.out.println(stackMins.peek());
    }
}
