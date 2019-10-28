package com.algorithm.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 生成窗口最大值的数组O(n)
 *
 * @author Jerry
 */
public class MaxWindow {

    private static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        //qmax维护一个递增的队列，存储数组元素的下标
        Deque<Integer> qmax = new LinkedList<>();
        //存储生成窗口的最大值数字
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        //因为对数组最多遍历arr.length次
        for (int i = 0; i < arr.length; i++) {
            //维护最大值队列最大队列如果小于新加的元素，则移除最后一个元素
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //添加索引
            qmax.addLast(i);
            //判断qmax最前元素是否过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            //每次都会执行一次，取出最大值
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = i;
        }
        int[] maxWindow = getMaxWindow(A, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.println(maxWindow[i]);
        }
    }
}
