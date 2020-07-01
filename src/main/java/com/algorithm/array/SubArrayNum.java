package com.algorithm.array;


import java.util.LinkedList;

public class SubArrayNum {

    public int getNum(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }

        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();

        int i = 0;
        int j = 0;
        int res = 0;

        while(i < arr.length){
            while(j < arr.length){
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j] ){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,4};
        new SubArrayNum().getNum(arr,3);
    }


}
