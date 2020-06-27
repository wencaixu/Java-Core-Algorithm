package com.algorithm.stack;


import java.util.Stack;

public class StackMins2<R extends Comparable> {
    private Stack<R> stackData;
    private Stack<R> stackMin ;

    public StackMins2() {
        this.stackData = new Stack<>();
        this.stackMin  = new Stack<>();
    }

    public void put(R element){
        if(stackMin.isEmpty()){
            stackMin.add(element);
        }else{
            R top = stackMin.peek();
            if(element.compareTo(top) <= 0){
                stackMin.push(element);
            }else{
                stackMin.push(top);
            }
        }
        stackData.add(element);
    }

    public R pop(){
        if(stackData.isEmpty()){
            return null;
        }else{
            stackMin.pop();
            return stackData.pop();
        }
    }

    public R getMin(){
        if(this.stackMin.isEmpty()){
            return null;
        }else{
            return stackMin.peek();
        }
    }


    public static void main(String[] args) {
        StackMins2<Integer> stackMins2 = new StackMins2<>();
        stackMins2.put(1);
        stackMins2.put(2);
        stackMins2.put(-1);
        stackMins2.put(0);

        System.out.println(stackMins2.pop());
        System.out.println(stackMins2.getMin());
    }

}
