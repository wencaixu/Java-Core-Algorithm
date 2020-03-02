package com.algorithm.string.com.algorithm.sort;

public class QuickSort1 {

    //基准取头法
    public void quickSort1(int[] T, int low, int top) {

        if (top <= low) {
            return;
        }
        int min = low;
        int max = top;

        int TMP = T[min];

        while (min < max) {
            while (min < max && T[max] >= TMP) {
                max--;
            }
            T[min] = T[max];
            while (min < max && T[min] <= TMP) {
                min++;
            }
            T[max] = T[min];
        }

        if (min == max) {
            T[min] = TMP;
        }
        if (min != low) {
            quickSort1(T, low, min - 1);
        }
        if (max != top) {
            quickSort1(T, max + 1, top);
        }
    }

    //基准取尾法
    public void quickSort2(int[] T, int low, int top) {

        if (low >= top) {
            return;
        }

        int min = low;
        int max = top;

        int R = T[top];

        while (min < max) {

            while (min < max && T[min] < R) {
                min++;
            }

            T[max] = T[min];
            while (min < max && T[max] > R) {
                max--;
            }
            T[min] = T[max];
        }

        if (max == min) {
            T[max] = R;
        }

        if (max != top) {
            quickSort2(T, max + 1, top);
        }

        if (min != low) {
            quickSort2(T, low, min - 1);
        }
    }

    public void quick(int[] T,int low,int high){
        if(low >= high){
            return ;
        }
        int l = low;
        int h = high;
        int t = T[low];

        while(low < high){
            while(low < high && T[high] >= t){
                high --;
            }
            T[low] = T[high];
            while(low < high && T[low] <= t){
                low ++;
            }
            T[high] = T[low];
        }

        if(low == high){
            T[low] = t;
        }

        if(low != l){
            quick(T,l,low-1);
        }

        if(high != h){
            quick(T,high+1,h);
        }

    }

    public static void main(String[] args) {

        int[] T = {1, 3, 2, 5, 4};
        new QuickSort1().quick(T, 0, 4);

        for (int i = 0; i < T.length; i++) {
            System.out.println(T[i]);
        }
    }
}
