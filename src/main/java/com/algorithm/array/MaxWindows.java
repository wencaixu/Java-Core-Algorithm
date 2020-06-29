package com.algorithm.array;

import java.util.LinkedList;

public class MaxWindows {

    public int[] getMaxWindows(int[] nums,int w){
        if(nums.length == 0 || nums.length < w){
            return null;
        }
        int[] ans = new int[nums.length-w+1];
        int index = 0;
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums.length;i++){
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() == i - w){
                deque.pollFirst();
            }
            if(i >= w - 1){
                ans[index++]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,5,4,3,3,6,7};
        new MaxWindows().getMaxWindows(nums,3);
    }


}
