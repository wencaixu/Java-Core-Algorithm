package com.algorithm.stack;

import java.util.Stack;

/**
 * 使用栈和递归函数实现栈操作的逆序
 */
public class StackReverse {

    private int reverse(Stack stack) {
        int value = (int) stack.pop();
        if (stack.isEmpty()) {
            return value;
        }
        int last = reverse(stack);
        stack.push(value);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        StackReverse reverse = new StackReverse();
        System.out.println(reverse.reverse(stack));
        System.out.println(stack.pop());
    }
}
