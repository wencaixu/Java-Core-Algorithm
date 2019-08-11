package com.algorithm.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *  此方式压入时耗费空间，弹出时浪费时间，时间复杂度O（1），空间复杂度O（n）
 */
public class MinOfStack2 {

    private static Stack<Integer> stackBase;

    private static Stack<Integer> stackMins;

    public MinOfStack2() {
        stackBase = new Stack<>();
        stackMins = new Stack<>();
    }

    /**
     * 数据压入：
     *      1. 将value添加到stackBase
     *      2. 如果stackMin为空，则直接压入到stackMin
     *      3. 如果value >= getMin() 则直接压入到stackBase
     *      4. 如果value < getMin() 则将value压入到stackMins中
     * @param value
     */
    private void push(int value) {
        stackBase.push(value);
        if(stackMins.isEmpty()){
            stackMins.push(value);
        }else{
            if(value < this.getMin()){
                stackMins.push(value);
            }
        }
    }

    /**
     * 删除元素
     *      1、stackBase与stackMins元素个数不相同
     *      2. 如果stackBase弹出元素value > getMin()，则stackBase弹出，stackMins不需要弹出
     *      3. 否则，两者均弹出
     */
    private int pop() {
        int value = stackBase.peek();
        if(value > this.getMin()){
            stackBase.pop();
        }else{
            stackBase.pop();
            stackMins.pop();
        }
        return value;
    }

    /**
     * 获取最小值
     *      1、获取最小值不等同于弹出最小值，仅仅需要获取顶部的最小值
     * @return
     */
    private int getMin() {
        return stackMins.peek();
    }

    public static void main(String[] args) {
        MinOfStack2 stack2 = new MinOfStack2();
        stack2.push(1);
        stack2.push(2);
        int pop = stack2.pop();
        System.out.println(pop);
        System.out.println(stack2.getMin());
    }
}
