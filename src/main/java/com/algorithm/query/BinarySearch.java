package com.algorithm.query;

public class BinarySearch {

    public <T extends Comparable> T search(T[] A, int low, int high, T n) {
        int mid = (low + high) / 2;

        if (low == high) {
            return (T) Integer.valueOf(-1);
        }

        if (0 < A[mid].compareTo(n)) {
            high = mid - 1;
            return search(A, low, high, n);
        } else if (0 > A[mid].compareTo(n)) {
            low = mid + 1;
            return search(A, low, high, n);
        }
        return A[mid];
    }

    public static void main(String[] args) {
        Integer[] t = {1, 3, 2};
        System.out.println(new BinarySearch().search(t, 1, 3, 2));
    }
}
