package com.algorithm.string.com.algorithm.queue;


import java.util.Stack;

/**
 * 使用两个栈实现队列
 *      实现思想：栈的两次弹出
 */
public class QueueStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 直接添加数据到stack1
     * @param node
     */
    private void push(int node) {
        stack1.add(node);
    }

    /**
     * 直接插入元素，stack1全部压入到stack2中，必须要保证stack2为空
     * @return
     */
    private int pop() throws Exception {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new Exception("队列为空");
        }
        if(stack2.empty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
            QueueStack stack = new QueueStack();
            stack.push(1);
            stack.push(2);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
    }
}
