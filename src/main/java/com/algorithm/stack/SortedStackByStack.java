package com.algorithm.stack;

import java.util.Stack;

/**
 * @author Jerry
 */
public class SortedStackByStack {

    /**
     * 方式一：获取栈中的最小值 类比的StackReverse
     *
     * @param stack
     * @return
     */
    private static int getMin(Stack<Integer> stack) {
        int min = stack.pop();
        if (stack.isEmpty()) {
            return min;
        } else {
            int last = getMin(stack);
            if (min < last) {
                stack.push(last);
                return min;
            }
            stack.push(min);
            return last;
        }
    }

    /**
     * 方式一：递归排序
     *
     * @param stack
     */
    private static void sorted(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int min = getMin(stack);
        sorted(stack);
        stack.push(min);
    }

    /**
     * 方式二：使用栈对其排序
     *
     * @param stack
     */
    private static void sortedByHelperStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (helper.isEmpty() && helper.peek() > current) {
                stack.push(helper.pop());
            }
            helper.push(current);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(5);

        sortedByHelperStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
