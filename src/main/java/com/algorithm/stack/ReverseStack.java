package com.algorithm.stack;

import java.util.Stack;


/**
 * Reverse stack
 *
 * @param <T> parameter
 * @author wencai.xu
 */
public class ReverseStack<T> {

    /**
     * Reverse Print
     *
     * @param stack stack
     */
    public void reverse(Stack<T> stack){
        if(stack.isEmpty()){
            return;
        }else{
            T peek = stack.pop();
            reverse(stack);
            System.out.println(peek);
        }
    }

    private T getLast(Stack<T> stack){
        T peek = stack.pop();
        if(stack.isEmpty()){
            return peek;
        } else {
            T last = getLast(stack);
            stack.add(peek);
            return last;
        }
    }

    /**
     * Reverse 1 *
     *
     * @param stack stack
     */
    public void reverse1(Stack<T> stack){
        if(stack.isEmpty()){
            return;
        }
        T last = getLast(stack);
        reverse1(stack);
        stack.push(last);
    }

    /**
     * Main
     *
     * @param args args
     */
    public static void main(String[] args) {
        ReverseStack<Integer> sortStack = new ReverseStack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        sortStack.reverse1(stack);
    }
}
