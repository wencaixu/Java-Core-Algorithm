package com.algorithm.string.com.algorithm.stack;

import java.util.Stack;

public class StackSort {

    public static Stack<Integer> help = new Stack<>();

    private Stack<Integer> sort;

    public StackSort(Stack<Integer> sort) {
        this.sort = sort;
    }

    public void sortStackByStack() {
        while(!sort.isEmpty()){
            int cur = sort.pop();
            while(!help.isEmpty() && help.peek() > cur){
                sort.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            sort.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        new StackSort(stack).sortStackByStack();
        System.out.println(stack);
    }
}
