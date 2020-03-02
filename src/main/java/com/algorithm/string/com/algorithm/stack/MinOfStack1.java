package com.algorithm.string.com.algorithm.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *  此方式压入时耗费时间，弹出时节省时间，时间复杂度O（1），空间复杂度O（n）
 */
public class MinOfStack1 {

    private static Stack<Integer> stackBase;

    private static Stack<Integer> stackMins;

    public MinOfStack1() {
        stackBase = new Stack<>();
        stackMins = new Stack<>();
    }

    /**
     * 添加元素
     *      1、压入规则：
     *          1. 将数据压入到stackBase中，判断stackMins是否为空
     *          2. 为空，则直接压入到stackMins，否则，与stackMins上最小值比较压入最小值
     */
    private void push(int value) {
        stackBase.push(value);
        if (stackMins.isEmpty()) {
            stackMins.push(value);
        } else {
            int peek = stackMins.peek();
            //相等或小于则直接压入,将数值重复压入
            if (value <= peek) {
                stackMins.push(value);
            } else {
                stackMins.push(peek);
            }
        }
    }

    /**
     * 删除元素
     *      1、stackMins与stackBase中元素个数相同
     *      2. 同时对stackMins与stackBase元素进行弹出
     */
    private void pop() {
         stackMins.pop();
         stackBase.pop();
    }

    /**
     * 获取最小值
     *      1、获取最小值不等同于弹出最小值，仅仅需要获取顶部的最小值
     * @return
     */
    private int getMin() {
        //stackMins中对应位置的值一定小于stackBase对应的值
        return stackMins.peek();
    }

    public static void main(String[] args) {
        MinOfStack1 stack = new MinOfStack1();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.getMin());
    }
}
