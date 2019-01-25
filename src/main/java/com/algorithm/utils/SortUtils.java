package com.algorithm.utils;

public class SortUtils {
    /**
     * a < b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * exchange
     *
     * @param A
     * @param i
     * @param j
     */
    public static void exec(Comparable[] A, int i, int j) {
        Comparable t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    /**
     * asc is sorted
     *
     * @param A
     * @return
     */
    public static boolean isSorted(Comparable[] A) {
        for (int i = 1; i < A.length; i++) {
            if (less(A[i], A[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
