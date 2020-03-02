package com.algorithm.string.com.algorithm.other;


public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0){
            return 0;
        }
        int min = array[0];
        for(int i = 1; i < len; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int a = -2;
        System.out.println(~(a));
    }
}
