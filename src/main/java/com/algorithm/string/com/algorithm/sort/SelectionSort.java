package com.algorithm.string.com.algorithm.sort;

import com.algorithm.string.com.algorithm.utils.SortUtils;

public class SelectionSort {

    public <T extends Comparable> void sort(T[] A) {
        for (int i = 0; i < A.length; i++) {
            int T = i;
            for (int j = i + 1; j < A.length; j++) {
                if (SortUtils.less(A[j], A[T])) {
                    T = j;
                }
            }
            SortUtils.exec(A, i, T);
        }
    }

    public static void main(String[] args) {
        Double[] a = {1.0, 1.3, 1.5};
        new SelectionSort().sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
