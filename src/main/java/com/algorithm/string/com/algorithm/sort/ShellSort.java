package com.algorithm.string.com.algorithm.sort;

import com.algorithm.string.com.algorithm.utils.SortUtils;

public class ShellSort {

    /**
     * 乱序交换
     *
     * @param A
     * @param <T>
     */
    public <T extends Comparable> void sort(T[] A) {

        int len = A.length;

        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                while (j - gap >= 0 && SortUtils.less(A[j], A[j - gap])) {
                    SortUtils.exec(A, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    public <T extends Comparable> void sortA(T[] A) {
        int len = A.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                T t = A[j];
                if (SortUtils.less(A[j], A[j - gap])) {
                    while (j - gap >= 0 && SortUtils.less(t, A[j - gap])) {
                        A[j] = A[j - gap];
                        j -= gap;
                    }
                    A[j] = t;
                }
            }
        }
    }


    public static void main(String[] args) {
        Double[] a = {1.4, 1.3, 1.5};
        new ShellSort().sortA(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
