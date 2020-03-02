package com.algorithm.string.com.algorithm.sort;

public class BubbleSort<T> {
    /**
     * 常规的冒泡排序
     *
     * @param A
     * @param <T>
     */
    public <T extends Comparable> void sort(T[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (0 <= A[i].compareTo(A[j])) {
                    T TMP = A[i];
                    A[i] = A[j];
                    A[j] = TMP;
                }
            }
        }
    }

    /**
     * 提前终止排序
     *
     * @param <T>
     * @param A
     * @return
     */

    public <T extends Comparable> boolean bubble(T[] A) {
        int len = A.length;
        boolean swapped = false;
        for (int i = 0; i < len - 1; i++) {
            if (A[i].compareTo(A[i + 1]) >= 0) {
                T TMP = A[i];
                A[i] = A[i + 1];
                A[i + 1] = TMP;
                swapped = true;
            }
        }
        return swapped;
    }

    public <T extends Comparable> void bubbleSort(T[] A) {
        for (int i = A.length; i > 0 && bubble(A); i--) ;
    }

    public static void main(String[] args) {
        Integer[] A = {1, 3, 2};
        new BubbleSort<Integer>().bubbleSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
