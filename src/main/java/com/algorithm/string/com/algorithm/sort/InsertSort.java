package com.algorithm.string.com.algorithm.sort;

import com.algorithm.string.com.algorithm.utils.SortUtils;

public class InsertSort {
    /**
     * 交换方式
     *
     * @param A
     * @param <T>
     */
    public <T extends Comparable> void sort(T[] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0 && SortUtils.less(A[j], A[j - 1]); j--) {
                SortUtils.exec(A, j, j - 1);
            }
        }
    }

    public <T extends Comparable> void exeSort(T[] A) {
        for (int i = 1; i < A.length; i++) {
            T t = A[i];
            int j;
            for (j = i; j > 0 && SortUtils.less(A[j], A[j - 1]); j--) {
                A[j] = A[j - 1];
            }
            A[j] = t;
        }
    }

    public static void main(String[] args) {
        Double[] a = {1.4, 1.3, 1.5};
        new InsertSort().exeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
