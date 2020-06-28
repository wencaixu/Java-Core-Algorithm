package com.algorithm.stack;

import java.util.Stack;

/**
 * Sort stack
 *
 * @param <T> parameter
 * @author wencai.xu
 */
public class SortStack<T extends Comparable> {

    private Stack<T> stack;

    /**
     * Sort stack
     *
     * @param stack stack
     */
    public SortStack(Stack<T> stack) {
        this.stack = stack;
    }

    /**
     * Get and remove min element t
     *
     * @param stack stack
     * @return the t
     */
    public T getAndRemoveMinElement(Stack<T> stack){
        T peek = stack.pop();
        if(stack.isEmpty()){
            return peek;
        }else{
            T min = getAndRemoveMinElement(stack);
            if(peek.compareTo(min) > 0){
                stack.push(peek);
                return min;
            }else{
                stack.push(min);
                return peek;
            }
        }
    }

    /**
     * Sort *
     *
     * @param stack stack
     */
    public void sort(Stack<T> stack){
        if(stack.isEmpty()){
            return;
        }
        T andRemoveMinElement = getAndRemoveMinElement(stack);
        sort(stack);
        stack.add(andRemoveMinElement);
    }


    public Stack<T> sort1(Stack<T> stack){
        Stack<T> help = new Stack<>();
        while(!stack.isEmpty()){
            T peek = stack.pop();
            while(!help.isEmpty() && help.peek().compareTo(peek) > 0){
                stack.push(help.pop());
            }
            help.push(peek);
        }
        return help;
    }
    /**
     * Main
     *
     * @param args args
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(0);
        stack.push(-1);
        SortStack<Integer> sortStack = new SortStack<>(stack);
        //System.out.println(sortStack.getAndRemoveMinElement(stack));
        //System.out.println(sortStack.getAndRemoveMinElement(stack));
        //sortStack.sort(stack);
        Stack<Integer> stack1 = sortStack.sort1(stack);
        while(!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
    }
}
