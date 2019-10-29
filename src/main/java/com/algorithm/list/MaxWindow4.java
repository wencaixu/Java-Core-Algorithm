package com.algorithm.list;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 两个双向队列
 */
public class MaxWindow4 {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int getWindowsNum(int[] arr, int Num) {

        //维护双向队列中的最大值
        LinkedList<Integer> max = new LinkedList<>();
        //维护双向队列中的最小值
        LinkedList<Integer> min = new LinkedList<>();

        int num = 0;
        int len = arr.length;

        int i = 0, j = 0;
        while (i < len) {
            while (j < len) {
                //如果最后一个元素大于新增元素，则将最后一个元素移除
                if (!min.isEmpty() && arr[min.peekLast()] >= arr[j]) {
                    min.pollLast();
                }
                //如果最后一个元素小于新增元素，则将最后一个元素移除
                min.addLast(j);
                if (!max.isEmpty() && arr[max.peekLast()] <= arr[j]) {
                    max.pollLast();
                }
                max.addLast(j);
                //如果出现结果大于Num，则进行下一次循环
                if(arr[max.getFirst()] - arr[min.getFirst()] > Num){
                    break;
                }
                j++;
            }
            //获取队列最小值
            if (min.peekFirst() == i) { min.pollFirst();}
            //获取队列最大值
            if (max.peekFirst() == i) { max.pollFirst();}
            //子数组的子数组都是符合的
            num += j - i;
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(getWindowsNum(arr,3));
    }
}
