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
        Deque<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
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
