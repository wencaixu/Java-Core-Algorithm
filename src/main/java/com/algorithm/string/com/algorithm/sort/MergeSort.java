package com.algorithm.string.com.algorithm.sort;

public class MergeSort {

    public void sort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(A, mid + 1, right);
        sort(A, left, mid);
        merge(A, left, mid, right);
    }

    public void merge(int[] A, int left, int mid, int right) {
        int[] TMP = new int[A.length];
        int r = mid + 1;
        int t = left, c = left;

        while (left <= mid && r <= right) {
            if (A[left] <= A[r]) {
                TMP[t++] = A[left++];
            } else {
                TMP[t++] = A[r++];
            }
        }

        while (left <= mid) {
            TMP[t++] = A[left++];
        }

        while (r <= right) {
            TMP[t++] = A[r++];
        }

        while (c <= right) {
            A[c] = TMP[c];
            c++;
        }
    }


    public static void main(String[] args) {
        int[] A = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        new MergeSort().sort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
